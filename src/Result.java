public class Result {
    private final double executionTime;
    private final int changes;
    private final int interactions;
    public double getExecutionTime() {
        return executionTime;
    }

    public int getChanges() {
        return changes;
    }

    public int getInteractions() {
        return interactions;
    }
    public Result(double executionTime, int changes, int interactions) {
        this.executionTime = executionTime;
        this.changes = changes;
        this.interactions = interactions;
    }
}
