
package cn.wagentim.buymanager.actions;

public class SayHello
{
    private String name;

    public String execute() throws Exception
    {
        return "success";
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
