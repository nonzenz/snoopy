
            var tabs,
                tabEvent = false,
                initialTab = 'Overview',
                navSelector = '#tabs .ui-tabs-nav',
                navFilter = function(el) {
                    return $(el).attr('href').replace(/^#/, '');
                },
                panelSelector = '#tabs .ui-tabs-panel',
                panelFilter = function() {
                    $(panelSelector + ' a').filter(function() {
                        return $(navSelector + ' a[title=' + $(this).attr('title') + ']').size() != 0;
                    }).each(function(event) {
                        $(this).attr('href', '#' + $(this).attr('title').replace(/ /g, '_'));
                    });
                };
            
            // Initializes plugin features
            $.address.strict(false).wrap(true);
            
            if ($.address.value() == '') {
                $.address.history(false).value(initialTab).history(true);
            }
            
            // Address handler
            $.address.init(function(event) {

                // Adds the ID in a lazy manner to prevent scrolling
                $(panelSelector).attr('id', initialTab);

                // Enables the plugin for all the content links
                $(panelSelector + ' a').address(function() {
                    return navFilter(this);
                });
                
                panelFilter();

                // Tabs setup
                tabs = $('#tabs')
                    .tabs({
                        load: function(event, ui) {
                            // Filters the content and applies the plugin if needed
                            $(ui.panel).html($(panelSelector, ui.panel).html());
                            panelFilter();
                        },
                        fx: {
                            opacity: 'toggle', 
                            duration: 'fast'
                        }
                    })
                    .css('display', 'block');

                // Enables the plugin for all the tabs
                $(navSelector + ' a').click(function(event) {
                	tabEvent = true;
                    $.address.value(navFilter(event.target));
                    tabEvent = false;
                    return false;
                });
            
            }).change(function(event) {

                var current = $('a[href=#' + event.value + ']:first');
                
                // Sets the page title
                $.address.title($.address.title().split(' | ')[0] + ' | ' + current.text());

                // Selects the proper tab
                if (!tabEvent) {
                    tabs.tabs('select', current.attr('href'));
                }
                
            });

            // Hides the tabs during initialization
            document.write('<style type="text/css"> #tabs { display: none; } </style>');