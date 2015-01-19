package com.zml.dao;

import java.util.ArrayList;

import com.zml.model.Node;

public interface NodeDao extends BaseDao<Node>{
	ArrayList<Node> getNodes(int type, int page, int pageCount);
	int getNodeSize(int type);

	boolean delNode(int id);
	boolean updateNode(Node node);
}
