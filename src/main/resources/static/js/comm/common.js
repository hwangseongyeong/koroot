const common = {
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

const util = {
    dateFormatter: function(value){
        let d = new Date(value)
        let month = '' + (d.getMonth() + 1);
        let day = '' + d.getDate()
        let year = d.getFullYear();
        if (month.length < 2) month = '0' + month;
        if (day.length < 2) day = '0' + day;
        return [year, month, day].join('-');
    }
}