public class Employment {
    private String name;
    private String post;

    public Employment() {
        System.out.println(Employment.class.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
