const $adminTable = $('#adminTable');

function initAdminTable(boardInfoId) {
    let url = '/api/board/list?boardInfoId=' + boardInfoId
    $adminTable.bootstrapTable('destroy').bootstrapTable({
        url: url,
        locale: "ko-KR",
        columns: [
            {
                title: '번호',
                field: 'boardPostId',
                align: 'center',
                width: 50
            }, {
                title: '제목',
                field: 'title',
                align: 'left',
                halign: 'center',
                width: 300
            }, {
                title: '작성자',
                field: 'createdBy',
                align: 'center',
                width: 50
            }, {
                title: '등록일',
                field: 'createdAt',
                align: 'center',
                formatter: util.dateFormatter,
                width: 50
            }, {
                title: '조회수',
                field: 'hit',
                align: 'center',
                width: 50
            }
        ]
    });

    $adminTable.on('click-row.bs.table', function (e, rowData) {
        location.href="/admin/board/" + rowData.boardPostId + "/detail";
    });
}

$(function() {
    initAdminTable('0');

    $("#boardSelect").on({
        change:function(){
            initAdminTable(this.value);
        }
    });
})