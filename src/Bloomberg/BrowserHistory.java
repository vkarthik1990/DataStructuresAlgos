package Bloomberg;


import java.util.ArrayList;
import java.util.List;

/*****
 *
 * LeetCode : 1472. Design Browser History
 * URL      : https://leetcode.com/problems/design-browser-history/
 *
 * Example :
 * Input:
 * ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
 * [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
 * Output:
 * [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
 *
 * Explanation:
 * BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
 * browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
 * browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
 * browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
 * browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
 * browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
 * browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
 * browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
 * browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
 * browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
 * browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
 *****/

public class BrowserHistory {

    private final String homePage;
    private List<String> webPageLst;
    private int currentCursor;

    public BrowserHistory(String homepage) {
        this.homePage=homepage;
        webPageLst=new ArrayList<>();
        webPageLst.add(homepage);
        this.currentCursor=0;
    }

    /*** Always get the list till the current cursor point and add the new vist next to it ***/
    public void visit(String url) {
        webPageLst = webPageLst.subList(0, currentCursor+1);
        webPageLst.add(url);
        currentCursor++;
    }

    /*** Can traverse only till min webpage home page in history , so check if back steps is with the range ***/
    public String back(int steps) {
        currentCursor = Math.max(0,currentCursor-steps);
        return webPageLst.get(currentCursor);
    }

    /*** Can traverse only max webpage list history , so check if forward steps is with the range ***/
    public String forward(int steps) {
        currentCursor = Math.min(webPageLst.size()-1,currentCursor+steps);
        return webPageLst.get(currentCursor);
    }

}
