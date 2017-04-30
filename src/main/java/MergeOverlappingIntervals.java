import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * Created by gopalbala on 29/4/17.
 */
public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        //Interval arr[] = {new Interval(6, 8), new Interval(1, 9), new Interval(2, 4), new Interval(4, 7)};
        Interval arr[] = {new Interval(1, 5), new Interval(2, 3), new Interval(4, 6 ),
                new Interval(7, 8), new Interval(8, 10), new Interval(12, 15)};
        mergeIntervals(Arrays.asList(arr)).forEach(System.out::println);

    }

    static List<Interval> mergeIntervals(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
            return null;

        Collections.sort(intervals, (o1, o2) -> {
            if (o1.getStart() != o2.getStart())
                return o1.getStart() - o2.getStart();
            else
                return o1.getEnd() - o2.getEnd();
        });
        List<Interval> result = new ArrayList<>();
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).getStart() > pre.getEnd()) {
                result.add(pre);
                pre = intervals.get(i);
            } else {
                Interval merged = new Interval(pre.getStart(),
                        Math.max(pre.getEnd(), (intervals.get(i).getEnd())));
                pre = merged;
            }
        }
        result.add(pre);
        return result;
    }

    static boolean compareIntervals(Interval a, Interval b) {
        return a.getStart() > b.getStart();
    }


}

@Getter
@Setter
@AllArgsConstructor
class Interval {
    int start;
    int end;

    @Override
    public String toString() {
        return start + ":" + end;
    }

}
