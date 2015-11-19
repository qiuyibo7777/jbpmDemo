Ext.onReady(function() {
			Ext.QuickTips.init();
			Ext.Loader.setConfig({
						enabled : true
					})
			Ext.Loader.setPath('Ext.ux','../extjs/examples/ux')
			Ext.require([
			'Ext.ux.data.PagingMemoryProxy',
			'Ext.ux.SlidingPager'
			])
			Ext.application({
						name : 'AM',
						appFolder : 'app',
						launch : function() {
							Ext.create("Ext.container.Viewport", {
										layout : 'auto',
										items : {
											width:"100%",
											height:"100%",
											xtype : 'taskView'
										}
									})
						},
						controllers:[
							   'TaskController'
						]
					})
		})