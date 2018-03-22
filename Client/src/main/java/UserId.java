public class UserId {

    private String userId;
    private String name;
    private String gitHub;

    public UserId(String userId, String name, String gitHub) {
        this.userId = userId;
        this.name = name;
        this.gitHub = gitHub;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGitHub() {
        return gitHub;
    }

    public void setGitHub(String gitHub) {
        this.gitHub = gitHub;
    }

    @Override
    public String toString(){
        return String.format("User ID: %s, Name: %s, GitHub: %s", this.userId, this.name, this.gitHub);
    }
}
