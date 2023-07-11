package entities;

public class Comment {
	
	int cid,tid;
	String cmt,uid;
	
	public Comment() {
		super();
	}

	public Comment(int cid, String cmt,int tid, String uid) {
		super();
		this.cid = cid;
		this.tid = tid;
		this.cmt = cmt;
		this.uid = uid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
}
