package fid.corefin.batch.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import fid.corefin.batch.data.ParameterRepository;
import fid.corefin.batch.model.entity.Parameter;


@ManagedBean(name = "batchBasicView")
@ViewScoped
public class BatchBasicView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1061723074392413811L;
	
	private ParameterRepository paramRepo;
	
	private TreeNode root;

	@ManagedProperty("#{batchOption}")
	private BatchOption batchOption;
	
	@PostConstruct
	public void init() {
		root = new DefaultTreeNode("Root", null);
		TreeNode all = new DefaultTreeNode("Corefin Batch", root);
		List<String> batchNames = batchOption.getBatchNames();
		for (String batchName : batchNames) {
			if (batchName != null && batchName.length() > 0) {
				TreeNode b = new DefaultTreeNode(batchName, all);
				
				//Parameter param = paramRepo.getParameterById(1);
//				List<String> types = dynamicOptions.getTypesToBrand(brand);
//				for (String type : types) {
//					if (type != null && type.length() > 0) {
//						TreeNode t = new DefaultTreeNode(type, b);
//					}
//				}
			}
		}
	}

	public TreeNode getRoot() {
		return root;
	}
	
	public void setBatchOption(BatchOption batchOption) {
		this.batchOption = batchOption;
	}
	
	public BatchOption getBatchOption() {
		return batchOption;
	}
}
