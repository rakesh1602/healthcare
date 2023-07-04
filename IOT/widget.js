// Initialize the widget
self.onInit = function() {
    // Set the label position based on the provided setting or default to 'left'
    self.ctx.labelPosition = self.ctx.settings.labelPosition || 'left';

    // Check if there are any datasources available
    if (self.ctx.datasources.length > 0) {
        // Get the first datasource
        var tbDatasource = self.ctx.datasources[0];

        // Generate a unique ID for the datasource container
        var datasourceId = 'tbDatasource' + 0;

        // Append the datasource container to the main container
        self.ctx.$container.append(
            "<div id='" + datasourceId +
            "' class='tbDatasource-container'></div>"
        );

        // Set the datasource container reference
        self.ctx.datasourceContainer = $('#' + datasourceId, self.ctx.$container);

        // Generate a unique ID for the table
        var tableId = 'table' + 0;

        // Append the table to the datasource container
        self.ctx.datasourceContainer.append(
            "<table id='" + tableId +
            "' class='tbDatasource-table'><col width='30%'><col width='70%'></table>"
        );

        // Get the table reference
        var table = $('#' + tableId, self.ctx.$container);

        // Adjust table alignment based on label position
        if (self.ctx.labelPosition === 'top') {
            table.css('text-align', 'left');
        }

        // Check if there are any data keys available
        if (tbDatasource.dataKeys.length > 0) {
            // Get the first data key
            var dataKey = tbDatasource.dataKeys[0];

            // Generate unique IDs for the label and value cells
            var labelCellId = 'labelCell' + 0;
            var cellId = 'cell' + 0;

            // Create the HTML structure for label and value cells based on label position
            if (self.ctx.labelPosition === 'left') {
                table.append(
                    "<tr><td class='tbDatasource-data-key' id='" + labelCellId + "'>" +
                    dataKey.label +
                    "</td><td class='tbDatasource-value' id='" +
                    cellId +
                    "'></td></tr>");
            } else {
                table.append(
                    "<tr style='vertical-align: bottom;'><td class='tbDatasource-data-key' id='" + labelCellId + "'>" +
                    dataKey.label +
                    "</td></tr><tr><td class='tbDatasource-value' id='" +
                    cellId +
                    "'></td></tr>");
            }

            // Set the references to the label and value cells
            self.ctx.labelCell = $('#' + labelCellId, table);
            self.ctx.valueCell = $('#' + cellId, table);

            // Initialize the value cell with default value
            self.ctx.valueCell.html(0 + ' ' + self.ctx.units);
        }
    }

    // Define a custom function to measure the width of the text
    $.fn.textWidth = function() {
        var html_org = $(this).html();
        var html_calc = '<span>' + html_org + '</span>';
        $(this).html(html_calc);
        var width = $(this).find('span:first').width();
        $(this).html(html_org);
        return width;
    };

    // Call the onResize function to adjust the widget's layout
    self.onResize();
};

// Update the widget's data
self.onDataUpdated = function() {
    // Check if the value cell and data are available
    if (self.ctx.valueCell && self.ctx.data.length > 0) {
        var cellData = self.ctx.data[0];
        if (cellData.data.length > 0) {
            var tvPair = cellData.data[cellData.data.length - 1];
            var value = tvPair[1];
            var txtValue;
            // Check if the value is a number
            if (isNumber(value)) {
                var decimals = self.ctx.decimals;
                var units = self.ctx.units;
                // Check if there are any data keys and override decimals and units if specified
                if (self.ctx.datasources.length > 0 && self.ctx.datasources[0].dataKeys.length > 0) {
                    dataKey = self.ctx.datasources[0].dataKeys[0];
                    if (dataKey.decimals || dataKey.decimals === 0) {
                        decimals = dataKey.decimals;
                    }
                    if (dataKey.units) {
                        units = dataKey.units;
                    }
                }
                // Format the value with specified decimals and units
                txtValue = self.ctx.utils.formatValue(value, decimals, units, true);
            } else {
                txtValue = value;
            }
            // Update the value cell with the formatted value
            self.ctx.valueCell.html(txtValue);

            // Calculate the target width and minimum delta based on label position
            var targetWidth;
            var minDelta;
            if (self.ctx.labelPosition === 'left') {
                targetWidth = self.ctx.datasourceContainer.width() - self.ctx.labelCell.width();
                minDelta = self.ctx.width / 16 + self.ctx.padding;
            } else {
                targetWidth = self.ctx.datasourceContainer.width();
                minDelta = self.ctx.padding;
            }

            // Calculate the initial delta and font size
            var delta = targetWidth - self.ctx.valueCell.textWidth();
            var fontSize = self.ctx.valueFontSize;

            // Adjust the font size to fit the cell width
            if (targetWidth > minDelta) {
                while (delta < minDelta && fontSize > 6) {
                    fontSize--;
                    self.ctx.valueCell.css('font-size', fontSize + 'px');
                    delta = targetWidth - self.ctx.valueCell.textWidth();
                }
            }
        }
    }
};

// Adjust the widget's layout on resize
self.onResize = function() {
    var labelFontSize;

    // Determine padding and font sizes based on label position
    if (self.ctx.labelPosition === 'top') {
        self.ctx.padding = self.ctx.height / 20;
        labelFontSize = self.ctx.height / 4;
        self.ctx.valueFontSize = self.ctx.height / 2;
    } else {
        self.ctx.padding = self.ctx.width / 50;
        labelFontSize = self.ctx.height / 2.5;
        self.ctx.valueFontSize = self.ctx.height / 2;
        // Adjust font sizes further if the aspect ratio is less than or equal to 2.7
        if (self.ctx.width / self.ctx.height <= 2.7) {
            labelFontSize = self.ctx.width / 7;
            self.ctx.valueFontSize = self.ctx.width / 6;
        }
    }

    // Ensure a maximum padding value
    self.ctx.padding = Math.min(12, self.ctx.padding);

    // Update label and value cell styles with calculated font sizes and padding
    if (self.ctx.labelCell) {
        self.ctx.labelCell.css('font-size', labelFontSize + 'px');
        self.ctx.labelCell.css('padding', self.ctx.padding + 'px');
    }
    if (self.ctx.valueCell) {
        self.ctx.valueCell.css('font-size', self.ctx.valueFontSize + 'px');
        self.ctx.valueCell.css('padding', self.ctx.padding + 'px');
    }
};

// Define the type parameters for the widget
self.typeParameters = function() {
    return {
        maxDatasources: 1,
        maxDataKeys: 1,
        singleEntity: true
    };
};

// Clean up the widget resources on destruction
self.onDestroy = function() {
};
