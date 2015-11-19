Ext.define('AM.view.ToolButtons',{
	extend:'Ext.panel.Panel',
	alias:'widget.toolButtons',
	id:'toolButtons',
    height:95,
    style: 'margin-top:3px',
    bodyStyle: 'padding:5px',
    autoScroll: false,
    tbar: [{
    		region:'center',
            xtype: 'buttongroup',
            columns: 3,
            title: '行政管理',
            items: [{
                text: '考勤管理',
                scale: 'large',
                rowspan: 3,
                icon: '../images/attendance.png',
                iconAlign: 'top',
                id:'attendance'
            },{
            	text: '系统管理',
                scale: 'large',
                rowspan: 3,
                icon: '../images/system.png',
                iconAlign: 'top',
                id:'system'
            }]
    	  }],
    initComponent : function() {
		this.callParent(arguments)
	}
})