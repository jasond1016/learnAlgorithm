package chapter08_stack;

/**
 * @author Jason
 * @date 2020/4/15
 */
public class SampleBrowser {
    private String currentPage;
    private StackBasedOnLinkedList backStack;
    private StackBasedOnLinkedList forwardStack;

    public SampleBrowser() {
        this.backStack = new StackBasedOnLinkedList();
        this.forwardStack = new StackBasedOnLinkedList();
    }

    public static void main(String[] args) {
        SampleBrowser browser = new SampleBrowser();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.back();
        browser.back();
        browser.forward();
        browser.open("http://www.qq.com");
        browser.forward();
        browser.back();
        browser.forward();
        browser.back();
        browser.back();
        browser.back();
        browser.back();
        browser.checkCurrentPage();
    }

    void open(String url) {
        if (this.currentPage == null) {
            showUrl("Open", url);
            return;
        }
        backStack.push(this.currentPage);
        showUrl("Open", url);
        forwardStack.clear();
    }

    boolean canGoForward() {
        return forwardStack.size() > 0;
    }

    void forward() {
        if (canGoForward()) {
            this.backStack.push(this.currentPage);
            showUrl("Forward", this.forwardStack.pop());
            return;
        }
        System.out.println("Cannot go forward.");
    }

    boolean canGoBack() {
        return backStack.size() > 0;
    }

    void back() {
        if (canGoBack()) {
            this.forwardStack.push(this.currentPage);
            showUrl("Back", this.backStack.pop());
            return;
        }
        System.out.println("Cannot go back.");
    }

    void showUrl(String prefix, String url) {
        this.currentPage = url;
        System.out.println(prefix + " page: " + this.currentPage);
    }

    void checkCurrentPage() {
        System.out.println("Current page: " + this.currentPage);
    }
}
