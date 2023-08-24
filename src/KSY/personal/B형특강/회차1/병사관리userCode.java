package KSY.personal.B형특강.회차1;

import java.util.*;

public class 병사관리userCode {
	
	private Set<Soldier> Soldiers;  // id -> team, score

	public void init()
	{
		Soldiers = new HashSet<>();  // 병사관리 리스트 생성 
	}
	
	public void hire(int mID, int mTeam, int mScore)
	{
		Soldiers.add(new Soldier(mID, mTeam, mScore));
		//System.out.println(mID + "병사 추가");
	}
	
	public void fire(int mID)
	{
		for(Soldier soldier : Soldiers) {
			if(soldier.mID == mID) {
				Soldiers.remove(soldier);
				//System.out.println(mID + "병사 제거");
				return;
			}
		}
		//해당하는 병사 찾지 못 함
	}

	public void updateSoldier(int mID, int mScore)
	{
		for(Soldier soldier: Soldiers) {
			if(soldier.mID == mID) {
				soldier.mScore = mScore;
				break;
			}
		}
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
		for(Soldier soldier: Soldiers) {
			if(soldier.mTeam == mTeam) {
				if(soldier.mScore + mChangeScore > 5)
					soldier.mScore = 5;
				else if(soldier.mScore + mChangeScore < 1)
					soldier.mScore = 1;
				else
					soldier.mScore = soldier.mScore + mChangeScore;
			}
		}
	}
	
	public int bestSoldier(int mTeam)
	{
		int maxTeamValue = 0, theID=0;
		for(Soldier soldier: Soldiers) {
			if(soldier.mScore > maxTeamValue) {
				theID = soldier.mID;
				maxTeamValue = soldier.mScore;
			}
			
		}
		return theID;
	}
	
	class soldier{
		private int mID;
		private int mTeam;
		private int mScore;
		public int getmID() {
			return mID;
		}
		public void setmID(int mID) {
			this.mID = mID;
		}
		public int getmTeam() {
			return mTeam;
		}
		public void setmTeam(int mTeam) {
			this.mTeam = mTeam;
		}
		public int getmScore() {
			return mScore;
		}
		public void setmScore(int mScore) {
			this.mScore = mScore;
		}
	}

}

class Soldier {
	int mID, mTeam, mScore;
	Soldier(int mID, int mTeam, int mScore){
		this.mID = mID; this.mTeam = mTeam; this.mScore = mScore;
	}
	@Override
	public int hashCode() {
		return mID;
	}
	@Override
	public boolean equals(Object obj) {
		return mID == ((Soldier)obj).mID;
	}
	
}
