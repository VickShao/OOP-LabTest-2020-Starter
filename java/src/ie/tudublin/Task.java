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
}