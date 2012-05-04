package model;

public abstract class Route
{
	public double getOverallExpMultiplier()
	{
		return (this.getForwardRoute().getMultiplierSum() + this.getReturnRoute().getMultiplierSum()) / this.getTurnsForRoute();
	}

	public double getOverallMoneyMultiplier()
	{
		return (this.getForwardRoute().getOverallMoneyMultiplier() + this.getReturnRoute().getOverallMoneyMultiplier()) / this.getTurnsForRoute();
	}

	public double getTurnsForRoute()
	{
		return this.getForwardRoute().getTurnsForRoute() + this.getReturnRoute().getTurnsForRoute();
	}

	public double getMultiplierSum()
	{
		return this.getForwardRoute().getMultiplierSum() + this.getReturnRoute().getMultiplierSum();
	}

	public boolean containsPort(int sectorID)
	{
		Route route = this.getReturnRoute();
		return (route != null && route.containsPort(sectorID)) || ((route = this.getForwardRoute()) != null && route.containsPort(sectorID));
	}

	public abstract Route getForwardRoute();

	public abstract Route getReturnRoute();

	public String getRouteString()
	{
		return this.getForwardRoute().getRouteString() + "\r\n" + this.getReturnRoute().getRouteString();
	}
}