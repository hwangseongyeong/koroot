const boardInfoId = $('#boardInfoId').val();

function initTable() {
    const $table = $('#table');
    $table.bootstrapTable('destroy').bootstrapTable({
        url: '/api/board/list?boardInfoId=' + boardInfoId,
        locale: "en-US",
        columns: [
            {
                title: 'No.',
                field: 'boardNo',
                align: 'center',
                width: 50
            }, {
                title: 'Subject',
                field: 'title',
                align: 'left',
                halign: 'center',
                width: 500
            }, {
                title: 'Writer',
                field: 'createdBy',
                align: 'center',
                width: 50
            }, {
                title: 'Date',
                field: 'createdAt',
                align: 'center',
                formatter: util.dateFormatter,
                width: 50
            }, {
                title: 'Hit',
                field: 'hit',
                align: 'center',
                width: 50
            }
        ]
    });

    $table.on('click-row.bs.table', function (e, rowData) {
        location.href="/board/" + rowData.boardPostId + "/detail";
    });
}