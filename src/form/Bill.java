package form;

public class Bill {
    private int Cost;
    private float _10PercentofCost;
    private float _90PercentofCost;
    
    public Bill(int Cost, float _10per, float _90per){
    this.Cost = Cost;
    this._10PercentofCost = _10per;
    this._90PercentofCost = _90per;
    }
    
    public void setCost(int Cost){
    this.Cost = Cost;
    }
    
    public void set_10PercentofCost(float _10PercentofCost){
    this._10PercentofCost = _10PercentofCost;
    }
    
    public void set_90PercentOfCost(float _90PercentofCost){
    this._90PercentofCost = _90PercentofCost;
    }
    
    public int getCost(){
    return Cost;
    }
    
    public float get_10PercentofCost(){
    return _10PercentofCost;
    }
    
    public float get_90PercentofCost(){
    return _90PercentofCost;
    }
}
