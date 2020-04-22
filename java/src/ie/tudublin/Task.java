package ie.tudublin;

import processing.data.TableRow;

public class Task {
    public  String Task;
    public int Start;
    public int End;

    public Task(String Task, int Start, int End){
        this.Task = Task;
        this.Start = Start;
        this.End = End;
    }

    public Task(TableRow tr){
        this(tr.getString("Task"), tr.getInt("Start"), tr.getInt("End"));
    }

    public String toString()
    {
        return  this.Task + ", " + this.Start + ", " + this.End;
    }

    public String Get_task(){
        return Task;
    }

    public int Get_start(){
        return Start;
    }

    public int Get_end(){
        return End;
    }
}