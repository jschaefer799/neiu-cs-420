package usmanf.models;

public enum TotalJobs {
    XSMALL(0, 100000),
    SMALL (100001, 125000),
    MEDIUM (125001, 175000),
    LARGE (175001, 200000),
    XLARGE (200001, 10000000);

    private final int min;
    private final int max;

    TotalJobs(int min, int max){
        this.min = min;
        this.max = max;
    }

    public int getMin(){
        return min;
    }

    public int getMax(){
        return max;
    }
}
