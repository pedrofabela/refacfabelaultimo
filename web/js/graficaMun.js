/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

gvChartInit();
jQuery(document).ready(function(){
    jQuery('#myTable2').gvChart({
        chartType: 'ColumnChart',
        gvSettings: {
            colors:['#F02139'],
            titleTextStyle:{
                color: '#8E0808',
                fontSize: '15'
            },
            vAxis: {
                title: 'CANTIDAD DE CASOS'
            },
            hAxis: {
                title: 'ESTATUS'
            },
            width: 700,
            height: 300
        }
    });

    jQuery('#myTable1').gvChart({
        chartType: 'PieChart',
        gvSettings: {
            colors:['#F40622', '#F02139','#EA354A','#E8495C','#E35B6B','#DF6D7A','#DE7C87','#DC8A93','#DC99A1','#D9A7AD','#DFB8BD'],
            titleTextStyle:{
                color: '#8E0808',
                fontSize: '15'
            },
            vAxis: {
                title: 'CANTIDAD DE CASOS'
            },
            hAxis: {
                title: 'REGION'
            },
            width: 700,
            height: 300

        // chartArea:{width:"50%",height:"75%"}

        }
    });
    jQuery('#myTable4').gvChart({
        chartType: 'ColumnChart',
        gvSettings: {
            colors:['#F02139'],
            titleTextStyle:{
                color: '#8E0808',
                fontSize: '15'
            },
            vAxis: {
                title: 'CANTIDAD DE CASOS'
            },
            hAxis: {
                title: 'INCIDENCIA'
            },
            width: 700,
            height: 300
        }
    });

    jQuery('#myTable3').gvChart({
        chartType: 'PieChart',
        gvSettings: {
            colors:['#F40622', '#F02139','#EA354A','#E8495C','#E35B6B','#DF6D7A','#DE7C87','#DC8A93','#DC99A1','#D9A7AD','#DFB8BD'],
            titleTextStyle:{
                color: '#8E0808',
                fontSize: '15'
            },
            vAxis: {
                title: 'CANTIDAD DE CASOS'
            },
            hAxis: {
                title: 'REGION'
            },
            width: 700,
            height: 300

        // chartArea:{width:"50%",height:"75%"}

        }
    });
});

