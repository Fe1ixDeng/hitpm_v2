package hitpm_v2.ICES_beans_variant;

public class Activity {
    private String name;
    private boolean isCircular = false;
    private boolean isFakeCircular = false;
    private int num;
    //画图相关的变量
    private Activity mainNext = null;
    private Activity elseNext = null;
    private boolean isMain;
    private boolean firstCircular;
    private boolean lastNotFakeCircular;

    public Activity(String name) {
        this.name = name;
    }

    public Activity(String name, boolean isCircular, boolean isFakeCircular) {
        this.name = name;
        this.isCircular = isCircular;
        this.isFakeCircular = isFakeCircular;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCircular() {
        return isCircular;
    }

    public void setCircular(boolean circular) {
        isCircular = circular;
    }

    public boolean isFakeCircular() {
        return isFakeCircular;
    }

    public void setFakeCircular(boolean fakeCircular) {
        isFakeCircular = fakeCircular;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Activity getMainNext() {
        return mainNext;
    }

    public void setMainNext(Activity mainNext) {
        this.mainNext = mainNext;
    }

    public Activity getElseNext() {
        return elseNext;
    }

    public void setElseNext(Activity elseNext) {
        this.elseNext = elseNext;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

    public boolean isFirstCircular() {
        return firstCircular;
    }

    public void setFirstCircular(boolean firstCircular) {
        this.firstCircular = firstCircular;
    }

    public boolean isLastNotFakeCircular() {
        return lastNotFakeCircular;
    }

    public void setLastNotFakeCircular(boolean lastNotFakeCircular) {
        this.lastNotFakeCircular = lastNotFakeCircular;
    }
}
