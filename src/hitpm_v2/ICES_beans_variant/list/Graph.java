import hitpm_v2.ICES_beans_variant.Activity;

import java.util.List;


public class Graph {
    private List<Activity> activityList;
    private boolean[][] flow;

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    public boolean[][] getFlow() {
        return flow;
    }

    public void setFlow(boolean[][] flow) {
        this.flow = flow;
    }

    //构造函数直接初始化矩阵
    public Graph(List<Activity> activityList) {
        this.activityList = activityList;
        this.flow = new boolean[activityList.size()][activityList.size()];
    }

    public int getNumOfActivity(){
        return activityList.size();
    }
    public Activity getActivity(int i){
        return activityList.get(i);
    }

    public boolean getFlow(int i, int j) throws Exception {
        if (i<0 || i >= activityList.size() || j < 0 || j >= activityList.size())
            throw new Exception("参数越界出错！");
        return flow[i][j];
    }
    public void setFlow(int i, int j, boolean aBoolean) throws Exception {
        if (i<0 || i >= activityList.size() || j < 0 || j >= activityList.size())
            throw new Exception("参数越界出错！");
        if(i != j)
            flow[i][j] = aBoolean;

    }

    //注意最后一个节点的情况
    public Activity getFirstNeighbor(int i) throws Exception {
        if (i < 0 || i >= activityList.size())
            throw new Exception("参数越界出错！");
        for(int j = i + 1; j < activityList.size(); j++){
            if (flow[i][j] == true)
                return activityList.get(i);
        }
        return new Activity("noNeighbor");  //标记endEvent后的一个节点不显示
    }
    //调用时要判断节点名称
    public Activity getNextNeighbor(int i, int j) throws Exception {
        if (i<0 || i >= activityList.size() || j < 0 || j >= activityList.size())
            throw new Exception("参数越界出错！");
        for(int k = j + 1; k < activityList.size(); k++){
            if(flow[i][k] == true)
                return activityList.get(k);
        }
        return new Activity("noNeighbor");  //没有下一个节点
    }
}
