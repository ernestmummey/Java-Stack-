class Project {
    // default to no value.... nothing is set
    private String name;
    private String description;

    //constructors

    // new Project()
    public Project(){
        System.out.println("nothing is here");
    }

    // new Project("name")
    public Project(String name){
        // setting the attribute to the value from the color paramenter
        this.name = name;
    }

    // new Project("name", "description")
    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }
        //instance method
    public String elevatorPitch(String name, String description){
        this.name = name;
        this.description = description;
        return this.name + ": " + this.description;
    }

        public void projectIntro(){
            System.out.println(this.name + " " + this.description );
        }
    
    //getter / setters ............... Post/Get request

    //getter Get Request
    public String getName(){
        return name;
    }

    //setter ..... Post request  
    public void setName(String newName){
        this.name = newName;
    }

    //getter
    public String getDescription(){
        return description;
    }

    //setter
    public void setDescription(String newDescription){
        this.description = newDescription;
    }

}
