var common = {
    trim: function(str){
        str = str.replace(/^\s+/, '');
        for (var i = str.length - 1; i > 0; i--) {
           if (/\S/.test(str.charAt(i))) {
               str = str.substring(0, i + 1);
               break;
            }
         }
         return str;
     },
     blockUI: function(){
         $.blockUI({
             baseZ: 9999,
             css: {
                 backgroundColor: 'transparent',
                 border: 'none'
             },
             message: '<div class="spinner-border" role="status"><span class="visually-hidden">Loading...</span></div>'
         });
     },
    unblockUI: function(){
        $.unblockUI();
    }
}