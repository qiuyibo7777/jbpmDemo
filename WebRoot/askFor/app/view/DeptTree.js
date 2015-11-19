Ext.define('AM.view.DeptTree',{
	extend:'Ext.tree.Panel',
	alias:'widget.deptTree',
	defaultRootId:'root',
	rootVisible : false,
	frame : true,
	store:'DeptStore',
	id:'deptTree',
	xtype:'deptTree'
	})