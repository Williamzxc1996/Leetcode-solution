/**
* 57. Insert Interval
* Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
* You may assume that the intervals were initially sorted according to their start times.
*/

/**
* Be careful of the case like {[1,2]} [3,4]
*
*
*/
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int start = newInterval.start, end = newInterval.end, i = 0, newStart = 0, newEnd = 0;
        while(i < intervals.size()){
            if(start > intervals.get(i).end)
                i++;
            else
                break;
        }
        // don't remove at this if-else because I don't change i if I remove here, it can't check the relationship between end           //and current Interval
        if(i >= intervals.size()){
            intervals.add(newInterval); // handle the case that newInterval is larger than any Interval in the intervals
            return intervals;
        }else if(i < intervals.size() && start > intervals.get(i).start){
            newStart = intervals.get(i).start;
        }else{
            newStart = start;
        }
        while(i < intervals.size()){
            if(end < intervals.get(i).start){
                newEnd = end;
                break;
            }else{
                if(end <= intervals.get(i).end){
                    newEnd = intervals.get(i).end;
                    intervals.remove(intervals.get(i));
                    break;
                }
                intervals.remove(intervals.get(i));
            }
        }
        newEnd = newEnd == 0 ? end : newEnd; //in case end is larger than the end of last Interval in intervals
        Interval res = new Interval(newStart,newEnd);
        intervals.add(i,res);
        return intervals;
    }
}
