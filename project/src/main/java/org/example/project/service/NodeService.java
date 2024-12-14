package org.example.project.service;


import org.example.project.model.Node;
import org.example.project.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class NodeService {

    @Autowired
    NodeRepository nodeRepository;

    public NodeService() {

    }

    public List<Node> getAllNodes() {
        return nodeRepository.getAllNodes();
    }

    public void updateDocSyncDate(int nodeId, Date lastDate) {
         nodeRepository.updateDocSyncDate(nodeId, lastDate);
    }

    public void updateSiteSyncDate(int nodeId, Date lastDate) {
        nodeRepository.updateSiteSyncDate(nodeId, lastDate);
    }
    public void updateContentSyncDate(int nodeId, Date lastDate) {
        nodeRepository.updateContentSyncDate(nodeId, lastDate);
    }
    public void updatePicSyncDate(int nodeId, Date lastDate) {
        nodeRepository.updatePicSyncDate(nodeId, lastDate);
    }



}
