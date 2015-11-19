Ext.define('AM.view.CenterPortal', {
			extend : 'Ext.panel.Panel',
			requires : ['Ext.app.Portlet', 'Ext.app.PortalColumn', 'Ext.app.PortalPanel',  
                       'Ext.app.PortalDropZone', 'Ext.ux.TabReorderer','Ext.ux.TabCloseMenu'],  
			alias : 'widget.centerPortal',
			layout : 'border',
			items : [{
						region : 'west',
						width : 200,
						layout : 'accordion',
						items : [{
									title : '菜单1',
									html : '菜单1的内容'
								}, {
									title : '菜单2',
									html : '菜单2的内容'
								}]
					}, {
						region : 'center',
						xtype : 'portalpanel',
						layout:'column',
						items : [{  
                                    xtype : 'portalcolumn',  
                                    columnWidth : 0.7,  
                                    items : [{  
                                                title : '新闻动态',  
                                                height : 150
                                            }, {  
                                                title : '最新通知', 
                                                height : 150
                                            }, {  
                                                title : '业绩报表',  
                                                height : 150 
                                            }, {  
                                                title : '邮件列表',  
                                                height : 150
                                            }]  
                                }, {  
                                    xtype : 'portalcolumn',  
                                    columnWidth : 0.3,  
                                    items : [{  
                                                title : '功能链接',  
                                                height : 150  
                                            }, {  
                                                title : '待办事项',  
                                                height : 150  
                                            }, {  
                                                title : '邮件列表',  
                                                height : 150  
                                            }, {  
                                                title : '邮件列表',  
                                                height : 150  
                                            }]
					}]
			}]
		})