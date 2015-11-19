Ext.define('AM.view.SystemTree',{
	extend:'Ext.tree.Panel',
	alias:'widget.systemTree',
	rootVisible : false,
	frame : true,
	xtype:'systemTree',
	root : {
				text : 'root',
				id : '0',
				leaf : false,
				children : [{
							expanded:true,
							text : '功能导航',
							id : 'system',
							leaf : false,
							children : [
									{
										text : '机构管理',
										id : 'dept',
										leaf : true
									},
									{
										text : '用户管理',
										id : 'user',
										leaf : true
									}, {
										text : '角色管理',
										id : 'role',
										leaf : true
									}]
						}]
			}
})