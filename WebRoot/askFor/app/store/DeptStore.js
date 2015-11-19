Ext.define('AM.store.DeptStore',{
	extend:'Ext.data.TreeStore',
	model:'DeptModel',
	proxy:{
		type: 'ajax',
       	url : 'deptView.do',
         reader: { 
			type: 'json'
		}
	},
	autoLoad:true
})