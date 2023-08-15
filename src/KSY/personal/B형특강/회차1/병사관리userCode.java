package KSY.personal.B형특강.회차1;

import java.util.*;

public class 병사관리userCode {
	
	private List<int[]> Soldiers;  // id -> team, score

	public void init()
	{
		Soldiers = new LinkedList<>();  // 병사관리 리스트
	}
	
	public void hire(int mID, int mTeam, int mScore)
	{
		for(int[] soldier : Soldiers) {
			if(soldier[0] == mID) {
				return; // 이미 있는 병사
			}
		}
		Soldiers.add(new int[] {mID, mTeam, mScore});
		System.out.println(mID + "병사 추가");
	}
	
	public void fire(int mID)
	{
		for(int[] soldier : Soldiers) {
			if(soldier[0] == mID) {
				Soldiers.remove(soldier);
				System.out.println(mID + "병사 제거");
				return;
			}
		}
		//해당하는 병사 찾지 못 함
	}

	public void updateSoldier(int mID, int mScore)
	{
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
	}
	
	public int bestSoldier(int mTeam)
	{
		return 0;
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
