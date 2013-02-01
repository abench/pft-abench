package com.example.tests;

public class GroupData implements Comparable<GroupData>{
	private String id;
	private String groupName;
	private String header;
	private String footer;
	
	public GroupData() {
		
	}

	@Override
	public String toString() {
		return "GroupData [groupName=" + groupName + "]";
	}

	@Override
	public int hashCode() {
		// final int prime = 31;
		int result = 1;
		//result = prime * result
		//		+ ((groupName == null) ? 0 : groupName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupData other = (GroupData) obj;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		return true;
	}
	

	@Override
	public int compareTo(GroupData other) {
		
		return this.groupName.compareTo(other.groupName);
	}

	public GroupData withGroupName(String name){
		this.groupName=name;
		return this;
	}
	
	public GroupData withHeader(String header) {
		this.header=header;
		return this;
	}
	
	public GroupData withId(String id) {
		this.id=id;
		return this;
	}


	public GroupData withFooter(String footer) {
		this.footer = footer;
		return this;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getHeader() {
		return header;
	}

	public String getFooter() {
		return footer;
	}
	
	
	
	
}