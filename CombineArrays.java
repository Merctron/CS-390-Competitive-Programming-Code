

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DiGiT_WiZARD on 9/5/16.
 */
public class YelpTest {
    public static void main(String[] args) {
        List<BInfo> tB = new ArrayList<BInfo>();
        tB.add(new BInfo(100, 1));
        tB.add(new BInfo(50, 2));
        List<BInfo> fB = new ArrayList<BInfo>();
        fB.add(new BInfo(70, 3));
        fB.add(new BInfo(60, 4));
        List<BInfo> st = merge(tB, fB);
        for (int i = 0; i < st.size(); i++) {
            System.out.println("Reviews: " + st.get(i).reviews + ", Id: " + st.get(i).id);
        }
    }

    public static List<BInfo> merge(List<BInfo> tb, List<BInfo> fb) {
        int totalB = tb.size() + fb.size();
        int tIndex = 0;
        int fIndex = 0;
        List<BInfo> st = new ArrayList<BInfo>();
        for (int i = 0; i < totalB; i++) {
            System.out.println(tIndex + ", " + fIndex);
            if (tIndex > tb.size() - 1) {
                st.add(fb.get(fIndex));
                fIndex++;
            }
            else if (fIndex > fb.size() - 1) {
                st.add(tb.get(tIndex));
                tIndex++;
            }
            else if (tb.get(tIndex).reviews > fb.get(fIndex).reviews) {
                st.add(tb.get(tIndex));
                tIndex++;
            }
            else {
                st.add(fb.get(fIndex));
                fIndex++;
            }
        }
        return  st;
    }
}

class BInfo {
    int reviews;
    int id;

    public BInfo(int r, int i) {
        this.reviews = r;
        this.id = i;
    }
}
