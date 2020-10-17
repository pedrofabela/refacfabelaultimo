/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

gvChartInit();
jQuery(document).ready(function(){
    jQuery('#myTable2').gvChart({
        chartType: 'ColumnChart',
        gvSettings: {
            colors:['#90AE21'],
            titleTextStyle:{
                color: '#8E0808',
                fontSize: '18'
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
            colors:['#516312', '#647A17','#78911C','#90AE21','#9CBE23','#ADD228','#BEE72C','#CDF830','#D4EE73','#D9EC96','#ECF9BF'],
            titleTextStyle:{
                color: '#8E0808',
                fontSize: '18'
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
            colors:['#90AE21'],
            titleTextStyle:{
                color: '#8E0808',
                fontSize: '18'
            },
            vAxis: {
                title: 'CANTIDAD DE CASOS'
            },
            hAxis: {
                title: 'TIPO AGRESIÓN'
            },
            width: 700,
            height: 300
        }
    });

    jQuery('#myTable3').gvChart({
        chartType: 'PieChart',
        gvSettings: {
            colors:['#516312', '#647A17','#78911C','#90AE21','#9CBE23','#ADD228','#BEE72C','#CDF830','#D4EE73','#D9EC96','#ECF9BF'],
            titleTextStyle:{
                color: '#8E0808',
                fontSize: '18'
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
