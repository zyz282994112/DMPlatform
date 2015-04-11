$(function(){
    function stripe() {
        $('#news').find('tr.alt').removeClass('alt');
        $('#news tbody').each(function() {
            $(this).children(':visible').has('td')
                .filter(function(index) {
                    return (index % 4) < 2;
                }).addClass('alt');
        });
    }
    stripe();
});
