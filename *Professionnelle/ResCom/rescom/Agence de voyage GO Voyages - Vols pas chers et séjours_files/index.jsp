    
(function () {
'use strict';
 
Odigeo.Settings.property('appContext', (function () {
return "/travel";
}()));  
Odigeo.browserBlacklist = {
xsell1718: 'microsoft edge,internet explorer,firefox,opera,safari',
xsell1718AdditionalBlocks: !Odigeo.Device.navigator.isBrowserVersion(49),
xsell1612: 'microsoft edge,internet explorer',
xsell1612AdditionalBlocks: !((Odigeo.Device.isIpad() && Odigeo.Device.navigator.isSafari)
|| (Odigeo.Device.navigator.isChrome && Odigeo.Device.navigator.isBrowserVersion(49))
|| (Odigeo.Device.navigator.isFirefox && Odigeo.Device.navigator.isBrowserVersion(63)))
};     
Odigeo.AB = {
getPriceTrends: 1,
faresInCalendar: 3,
faresInCalendarMobile: 3,
addHotelCheckbox: 1,
isFareUpgradeEnabled: true,
isFareUpgradeRenderable: false,
isDeactivateAvuxi:true,
isDynpackShareSelection: true,
isFlexibleDatesOWActive: true,
isFlexibleDatesOWControl: false,
isRepricingOldPriceDesktop: true,
getDesktopFlexibleDatesRoundTrip: 1,
getDesktopFlexibleDatesOneWayImprovements: 1,
getMobileFlexibleDatesRoundTripImprovements: 3,
getMobileFlexibleDatesOneWayImprovements: 3,
getFlexibleDatesOW: 1,
getFlexibleDatesRT: 1,
isMobileFlightInfoRefactor: true,
isMobileUnifyFlightSummaryTripDetails: true,
isCheckingRepricingConcept: false,
isDeactivateRepricingConcept: true,
isBaggageDiscountEnabled: false,
isCvvCleanedAfterRepricing: true,
isFlexibleDatesSummaryOW: true,
isBrowserNotificationsMeta: true,
isHeroImage: true,
isItineraryBagPriceSplitMobile: true,
isItineraryBagPriceSplitDesktop: true,
isMPIRouteDesktop: false,
isMPIRouteMobile: false,
isFreeFeeCharge: true,
isIntermediatePageMobileFlightsImpact: true,
isExpediaLinksAndWidget: true,
isIntermediatePageForOwDesktop: true,
isMobileFiltersHeader: false,
membershipPriceDisplayEmptyButtons: false,
membershipPriceDisplayTwoButtons: false,
membershipPriceDisplayExpanded: false,
membershipPriceDisplayExpandedDualD: true,
isMembershipUserEnumeration: false,
membershipProfitablePopupInResults: false,
isMembershipRemoving10MinWarningMessage: true,
membershipMoreExplanationForPrimePriceD: 1,
membershipEmphasiseSubscriptionConceptD: false,
membershipSwapExpandedPricesD: false,
membershipSmokePerksD: 1,
isMembershipFaresDiscoveryD: false,
isMembershipFaresDiscoveryM: false,
isMembershipFaresDiscoveryArrowD: false,
isMembershipFaresDiscoveryArrowM: false,
isMembershipEnhanceFilterDisplayD: false,
isMembershipEnhanceShowMoreDisplayD: false,
isMembershipMoreExplanationFixingBanner: false,
isMemberSmoothSubscription: false,
isMembershipFareFilterD: false,
isMembershipFareFilterM: false,
isMembershipFareFilterStickyD: false,
isMembershipFareFilterStickyM: false,
isReturningBookersNotification: false,
isPostBookingBagsPayment: true,
isSeatmapNagDirectMobile: false,
isSeatMapCta3Pax: false,
promotionMerchandisingBadgePartition: 1,
isBaggageFeeHint: true,
isBaggageIncludedInFlightsummary: true,
isDynpackMobileNewProductSelection: false,
isDynpackMobileNewSearch: false,
isDynpackMobileFilterHotelName: true,
isDynpackPriceDisplay: true,
isDynpackMobilePriceDisplay: true,
isDisabledRetriesMobile: true,
isNewWarningPopup: false,
isSeatmapMobileColors: true,
isUpdateBagClaimTextUk: true,
isOfferChildrenAgeDesktop: false,
isDynpackMobileWaitingPage: true,
isDynpackMobileCompressedHeader: true,
isDynpackMobileSuggestedResults: false,
isAddOfflineSalesToHotelResults: true,
isNotIP: false,
isDesktopStaticModelAppliedToIP: true,
isNotMobileIP: false,
isMobileStaticModelAppliedToIP: false,
isDPTNagReminder: true,
isDPTMobileNagReminder: false,
mobileResultsPriceTrend: false,
isMobileResultsOWNoDepartureText: false,
isHidingBannedAirlineLogos: false,
isCoSearchInOriginalTab: false,
noResultsCopyDesktop: 2,
noResultsCopyMobile: 2,
isMytripsAutochekinEnabled: false,
isMyTripsPostBookingBagsButton: true,
isMyTripsPostBookingSeatsButton: true,
isPostBookingSeatsDesktop: true,
isRecaptchaLoginEnabled: false,
isAccommodationPostBookingMobileEnabled: false,
isAccommodationPostBookingEnabled: false,
noStopsCopyTestPartition: 2,
hideBaggageInfoEnabled: false,
isBaggageGroupedBySegment: true,
mobileWidgetProminentPartition: 1,
isServiceOptionsInMyTrips: true,
isServiceOptionsInMyTripsMobile: false,
isMobileResultsBoxReduceHeight: false,
isMobileClearPrices: true,
isFareC4ARinPaxEnabled: false,
isNewCreateShoppingCart: false,
isNewTicketsLeftOnTop: false,
mobileResultsIncreasePrices: false,
mobileResultsFareTrends: 1,
isWaitingMessageActive: false,
isFixWaitingPageDesktop: true,
isFixWaitingPageMobile: true,
isRecentSearchesDynpack: true,
isPriceWidgetOnTop: false,
isUpdateBannersTextlinkConfPage: false,
isImportantInfoMobile: true,
isRecaptchaEnabled: true,
newsletterSubscriptionCheckedPartition: 2,
isNewDOBPicker: false,
preloadPartition: 1,
isDesktopPricesMayIncrease: false,
isSmartNagTwoPaxPreselected: true,
getBoardingOptionsWidget: 3,
isMembershipProductSellingEnabled: true,
sortingTabsPartition: 2,
sortingTabsEnabled: true,
exitSurveyTrigger: 1,
sessionFreeze: true,
isKlarnaSkeleton: false,
isMetaAncillariesPageActive: false,
updateXsellBannersMobileConfPage: 2,
confirmationMytripsAutomaticRedirection: 1,
isPriceSummaryDesktop: true,
isPriceSummaryMobile: true,
isDynpackDesktopMultiTab: false,
isDynpackFilterOurSelection: true,
isDynpackMobileFilterOurSelection: true,
isBuyerFormFunctionalityDecoupledInMobile: false,
isRemoveBrowserNotification: true,
isSmartblockSixCars: true,
isManageMyBookingDesktop: true,
isTrackTouroperatorFaresActive: false,
hasToSetTrackingCookiesOnServerSide: true,
getMyTripsPhase1QrDesktop: 3,
getNewsletterBannerResults2: 1,
isXsellHomePageNewTab: false
&& Odigeo.Device.navigator.isCurrentBrowserBlacklisted(Odigeo.browserBlacklist.xsell1612)
&& Odigeo.browserBlacklist.xsell1612AdditionalBlocks,
isSearchExtensionFilteredByBrowser: false
&& Odigeo.Device.navigator.isCurrentBrowserBlacklisted(Odigeo.browserBlacklist.xsell1718)
&& Odigeo.browserBlacklist.xsell1718AdditionalBlocks,
isInspectletNewCreateShoppingCartDesktop: false,
isInspectletNewCreateShoppingCartMobile: true,
isBagPropensityNag: false,
isSmartNagManager: false,
repricingPopupFromCollectionDataEnabled: true,
isBoardingOptionsOE: false,
isBoardingOptionsOEWithCrossFaring: false,
isDynpackSplitResultsPage: false,
getFlexibilityDisruption: 1,
getChangeSPPageOrderMeta: 1,
getChangeSPPageOrderNonMeta: 1,
isTcMovedFromRefundableTicketToDisclaimer: false,
buyerWidgetPayment: false,
isSeatMapCtaHeaderHidden: true,
isBaggageVinDisclaimer: true,
isFlightSummaryImprovementsV1: false,
isBetterDetailsWrapActive: false,
boardingOptionsMobile: false,
isYesNoEnabledDesktop: false,
isPrefetchAncillariesModule: false,
}; 
Odigeo.JCMS = {
extendSessionTime: '1020000',
fareTrendsIncrementPerDaysTreshold: '',
carriersWithSmallBagInCabin: 'FR, W6, NK, WW, G4, PD, WJ, H2, OE',
flexibleDatesDaysOfFlexibility: '15',
priceFreshnessDays: '5',
searchStrategy: 'SEARCH_PRICE',
isFaresCalendarAmountMarketEnabled: true,
hubInsurancePolicyDetailsUrl: ''
};
Odigeo.BagsAndSeats = {
trackBookingIdOnDialup: false
}      
//TODO Delete this config object when Storage is implemented
Odigeo.UserArea = {
countryId: 'fr',
countries: [{code: "AF", name: "Afghanistan", phonePrefix: "+93"},{code: "ZA", name: "Afrique du Sud", phonePrefix: "+27"},{code: "AL", name: "Albanie", phonePrefix: "+355"},{code: "DZ", name: "Algérie", phonePrefix: "+213"},{code: "DE", name: "Allemagne", phonePrefix: "+49"},{code: "AD", name: "Andorre", phonePrefix: "+376"},{code: "AO", name: "Angola", phonePrefix: "+244"},{code: "AI", name: "Anguilla", phonePrefix: "+1 264"},{code: "AQ", name: "Antarctique", phonePrefix: "+672"},{code: "AG", name: "Antigua-et-Barbuda", phonePrefix: "+1 268"},{code: "AN", name: "Antilles Néerlandaises", phonePrefix: "+599"},{code: "SA", name: "Arabie saoudite", phonePrefix: "+966"},{code: "AR", name: "Argentine", phonePrefix: "+54"},{code: "AM", name: "Arménie", phonePrefix: "+374"},{code: "AW", name: "Aruba", phonePrefix: "+297"},{code: "AU", name: "Australie", phonePrefix: "+61"},{code: "AT", name: "Autriche", phonePrefix: "+43"},{code: "AZ", name: "Azerbaïdjan", phonePrefix: "+994"},{code: "BS", name: "Bahamas", phonePrefix: "+1 242"},{code: "BH", name: "Bahreïn", phonePrefix: "+973"},{code: "BD", name: "Bangladesh", phonePrefix: "+880"},{code: "BB", name: "Barbade", phonePrefix: "+1 246"},{code: "BY", name: "Bélarus", phonePrefix: "+375"},{code: "BE", name: "Belgique", phonePrefix: "+32"},{code: "BZ", name: "Belize", phonePrefix: "+501"},{code: "BJ", name: "Bénin", phonePrefix: "+229"},{code: "BM", name: "Bermudes", phonePrefix: "+1 441"},{code: "BT", name: "Bhoutan", phonePrefix: "+975"},{code: "BO", name: "Bolivie", phonePrefix: "+591"},{code: "BA", name: "Bosnie-Herzégovine", phonePrefix: "+387"},{code: "BW", name: "Botswana", phonePrefix: "+267"},{code: "BR", name: "Brésil", phonePrefix: "+55"},{code: "BN", name: "Brunei", phonePrefix: "+673"},{code: "BG", name: "Bulgarie", phonePrefix: "+359"},{code: "BF", name: "Burkina Faso", phonePrefix: "+226"},{code: "BI", name: "Burundi", phonePrefix: "+257"},{code: "KH", name: "Cambodge", phonePrefix: "+855"},{code: "CM", name: "Cameroun", phonePrefix: "+237"},{code: "CA", name: "Canada", phonePrefix: "+1"},{code: "CV", name: "Cap-Vert", phonePrefix: "+238"},{code: "BQ", name: "Caribbean Netherlands", phonePrefix: "+599"},{code: "CL", name: "Chili", phonePrefix: "+56"},{code: "CN", name: "Chine", phonePrefix: "+86"},{code: "CY", name: "Chypre", phonePrefix: "+357"},{code: "CO", name: "Colombie", phonePrefix: "+57"},{code: "KM", name: "Comores", phonePrefix: "+269"},{code: "KP", name: "Corée du Nord", phonePrefix: "+850"},{code: "KR", name: "Corée du Sud", phonePrefix: "+82"},{code: "CR", name: "Costa Rica", phonePrefix: "+506"},{code: "CI", name: "Côte d'Ivoire", phonePrefix: "+225"},{code: "HR", name: "Croatie", phonePrefix: "+385"},{code: "CU", name: "Cuba", phonePrefix: "+53"},{code: "CW", name: "Curaçao", phonePrefix: "+599"},{code: "DK", name: "Danemark", phonePrefix: "+45"},{code: "DJ", name: "Djibouti", phonePrefix: "+253"},{code: "DM", name: "Dominique", phonePrefix: "+1 767"},{code: "EG", name: "Égypte", phonePrefix: "+20"},{code: "AE", name: "Émirats arabes unis", phonePrefix: "+971"},{code: "EC", name: "Équateur", phonePrefix: "+593"},{code: "ER", name: "Érythrée", phonePrefix: "+291"},{code: "ES", name: "Espagne", phonePrefix: "+34"},{code: "EE", name: "Estonie", phonePrefix: "+372"},{code: "US", name: "États-Unis", phonePrefix: "+1"},{code: "ET", name: "Éthiopie", phonePrefix: "+251"},{code: "FJ", name: "Fidji", phonePrefix: "+679"},{code: "FI", name: "Finlande", phonePrefix: "+358"},{code: "FR", name: "France", phonePrefix: "+33"},{code: "GA", name: "Gabon", phonePrefix: "+241"},{code: "GM", name: "Gambie", phonePrefix: "+220"},{code: "GE", name: "Géorgie", phonePrefix: "+995"},{code: "GS", name: "Géorgie du Sud et les Îles Sandwich du Sud", phonePrefix: "+500"},{code: "GH", name: "Ghana", phonePrefix: "+233"},{code: "GI", name: "Gibraltar", phonePrefix: "+350"},{code: "GR", name: "Grèce", phonePrefix: "+30"},{code: "GD", name: "Grenade", phonePrefix: "+1 473"},{code: "GL", name: "Groenland", phonePrefix: "+299"},{code: "GP", name: "Guadeloupe", phonePrefix: "+590"},{code: "GU", name: "Guam", phonePrefix: "+1 671"},{code: "GT", name: "Guatemala", phonePrefix: "+502"},{code: "GN", name: "Guinée", phonePrefix: "+224"},{code: "GW", name: "Guinée-Bissau", phonePrefix: "+245"},{code: "GQ", name: "Guinée équatoriale", phonePrefix: "+240"},{code: "GY", name: "Guyana", phonePrefix: "+592"},{code: "GF", name: "Guyane Française", phonePrefix: "+594"},{code: "HT", name: "Haïti", phonePrefix: "+509"},{code: "HN", name: "Honduras", phonePrefix: "+504"},{code: "HK", name: "Hong-kong", phonePrefix: "+852"},{code: "HU", name: "Hongrie", phonePrefix: "+36"},{code: "BV", name: "Île Bouvet", phonePrefix: "+47"},{code: "CX", name: "Île Christmas", phonePrefix: "+61"},{code: "HM", name: "Île Heard et Îles McDonald", phonePrefix: "+61"},{code: "MU", name: "Île Maurice", phonePrefix: "+230"},{code: "NF", name: "Île Norfolk", phonePrefix: "+6723"},{code: "KY", name: "Îles Caïmanes", phonePrefix: "+1 345"},{code: "CC", name: "Îles Cocos", phonePrefix: "+61"},{code: "CK", name: "Îles Cook", phonePrefix: "+682"},{code: "AX", name: "Îles d'Åland", phonePrefix: "+358"},{code: "FO", name: "Îles Féroé", phonePrefix: "+298"},{code: "FK", name: "Îles Malouines", phonePrefix: "+500"},{code: "MP", name: "Îles Mariannes du Nord", phonePrefix: "+1 670"},{code: "MH", name: "Îles Marshall", phonePrefix: "+692"},{code: "UM", name: "Îles Mineures éloignées des États-Unis", phonePrefix: "+1"},{code: "SB", name: "Îles Salomon", phonePrefix: "+677"},{code: "TC", name: "Îles Turques et Caïques", phonePrefix: "+1 649"},{code: "VG", name: "Îles Vierges Britanniques", phonePrefix: "+1 284"},{code: "VI", name: "Îles Vierges des États-Unis", phonePrefix: "+1 340"},{code: "IN", name: "Inde", phonePrefix: "+91"},{code: "ID", name: "Indonésie", phonePrefix: "+62"},{code: "IQ", name: "Irak", phonePrefix: "+964"},{code: "IR", name: "Iran", phonePrefix: "+98"},{code: "IE", name: "Irlande", phonePrefix: "+353"},{code: "IS", name: "Islande", phonePrefix: "+354"},{code: "IL", name: "Israël", phonePrefix: "+972"},{code: "IT", name: "Italie", phonePrefix: "+39"},{code: "JM", name: "Jamaïque", phonePrefix: "+1 876"},{code: "JP", name: "Japon", phonePrefix: "+81"},{code: "JE", name: "Jersey", phonePrefix: "+44"},{code: "JO", name: "Jordanie", phonePrefix: "+962"},{code: "KZ", name: "Kazakhstan", phonePrefix: "+7"},{code: "KE", name: "Kenya", phonePrefix: "+254"},{code: "KG", name: "Kirghizistan", phonePrefix: "+996"},{code: "KI", name: "Kiribati", phonePrefix: "+686"},{code: "XK", name: "Kosovo", phonePrefix: "+381"},{code: "KW", name: "Koweït", phonePrefix: "+965"},{code: "LA", name: "Laos", phonePrefix: "+856"},{code: "LS", name: "Lesotho", phonePrefix: "+266"},{code: "LV", name: "Lettonie", phonePrefix: "+371"},{code: "LB", name: "Liban", phonePrefix: "+961"},{code: "LR", name: "Libéria", phonePrefix: "+231"},{code: "LY", name: "Libye", phonePrefix: "+218"},{code: "LI", name: "Liechtenstein", phonePrefix: "+423"},{code: "LT", name: "Lituanie", phonePrefix: "+370"},{code: "LU", name: "Luxembourg", phonePrefix: "+352"},{code: "MO", name: "Macao", phonePrefix: "+853"},{code: "MK", name: "Macédoine", phonePrefix: "+389"},{code: "MG", name: "Madagascar", phonePrefix: "+261"},{code: "MY", name: "Malaisie", phonePrefix: "+60"},{code: "MW", name: "Malawi", phonePrefix: "+265"},{code: "MV", name: "Maldives", phonePrefix: "+960"},{code: "ML", name: "Mali", phonePrefix: "+223"},{code: "MT", name: "Malte", phonePrefix: "+356"},{code: "MA", name: "Maroc", phonePrefix: "+212"},{code: "MQ", name: "Martinique", phonePrefix: "+596"},{code: "MR", name: "Mauritanie", phonePrefix: "+222"},{code: "YT", name: "Mayotte", phonePrefix: "+262"},{code: "MX", name: "Mexique", phonePrefix: "+52"},{code: "FM", name: "Micronésie", phonePrefix: "+691"},{code: "MD", name: "Moldavie", phonePrefix: "+373"},{code: "MC", name: "Monaco", phonePrefix: "+377"},{code: "MN", name: "Mongolie", phonePrefix: "+976"},{code: "ME", name: "Monténégro", phonePrefix: "+382"},{code: "MS", name: "Montserrat", phonePrefix: "+1 664"},{code: "MZ", name: "Mozambique", phonePrefix: "+258"},{code: "MM", name: "Myanmar", phonePrefix: "+95"},{code: "NA", name: "Namibie", phonePrefix: "+264"},{code: "NR", name: "Nauru", phonePrefix: "+674"},{code: "NP", name: "Népal", phonePrefix: "+977"},{code: "NI", name: "Nicaragua", phonePrefix: "+505"},{code: "NE", name: "Niger", phonePrefix: "+227"},{code: "NG", name: "Nigéria", phonePrefix: "+234"},{code: "NU", name: "Niué", phonePrefix: "+683"},{code: "NO", name: "Norvège", phonePrefix: "+47"},{code: "NC", name: "Nouvelle-Calédonie", phonePrefix: "+687"},{code: "NZ", name: "Nouvelle-Zélande", phonePrefix: "+64"},{code: "OM", name: "Oman", phonePrefix: "+968"},{code: "UG", name: "Ouganda", phonePrefix: "+256"},{code: "UZ", name: "Ouzbékistan", phonePrefix: "+998"},{code: "PK", name: "Pakistan", phonePrefix: "+92"},{code: "PW", name: "Palaos", phonePrefix: "+680"},{code: "PS", name: "Palestine", phonePrefix: "+970"},{code: "PA", name: "Panama", phonePrefix: "+507"},{code: "PG", name: "Papouasie-Nouvelle-Guinée", phonePrefix: "+675"},{code: "PY", name: "Paraguay", phonePrefix: "+595"},{code: "NL", name: "Pays-Bas", phonePrefix: "+31"},{code: "PE", name: "Pérou", phonePrefix: "+51"},{code: "PH", name: "Philippines", phonePrefix: "+63"},{code: "PN", name: "Pitcairn", phonePrefix: "+870"},{code: "PL", name: "Pologne", phonePrefix: "+48"},{code: "PF", name: "Polynésie Française", phonePrefix: "+689"},{code: "PR", name: "Porto Rico", phonePrefix: "+1"},{code: "PT", name: "Portugal", phonePrefix: "+351"},{code: "QA", name: "Qatar", phonePrefix: "+974"},{code: "CF", name: "République centrafricaine", phonePrefix: "+236"},{code: "CD", name: "République démocratique du Congo", phonePrefix: "+243"},{code: "DO", name: "République dominicaine", phonePrefix: "+1 809"},{code: "CG", name: "République du Congo", phonePrefix: "+242"},{code: "CZ", name: "République tchèque", phonePrefix: "+420"},{code: "RE", name: "Réunion", phonePrefix: "+262"},{code: "RO", name: "Roumanie", phonePrefix: "+40"},{code: "GB", name: "Royaume-Uni", phonePrefix: "+44"},{code: "RU", name: "Russie", phonePrefix: "+7"},{code: "RW", name: "Rwanda", phonePrefix: "+250"},{code: "EH", name: "Sahara Occidental", phonePrefix: "+212"},{code: "KN", name: "Saint-Christophe-et-Niévès", phonePrefix: "+1 869"},{code: "SH", name: "Sainte-Hélène", phonePrefix: "+290"},{code: "LC", name: "Sainte-Lucie", phonePrefix: "+1 758"},{code: "SM", name: "Saint-Marin", phonePrefix: "+378"},{code: "PM", name: "Saint-Pierre-et-Miquelon", phonePrefix: "+508"},{code: "VC", name: "Saint-Vincent-et-les Grenadines", phonePrefix: "+1 784"},{code: "SV", name: "Salvador", phonePrefix: "+503"},{code: "WS", name: "Samoa", phonePrefix: "+685"},{code: "AS", name: "Samoa Américaines", phonePrefix: "+1 684"},{code: "ST", name: "Sao Tomé-et-Principe", phonePrefix: "+239"},{code: "SN", name: "Sénégal", phonePrefix: "+221"},{code: "RS", name: "Serbie", phonePrefix: "+381"},{code: "SC", name: "Seychelles", phonePrefix: "+248"},{code: "SL", name: "Sierra Leone", phonePrefix: "+232"},{code: "SG", name: "Singapour", phonePrefix: "+65"},{code: "SX", name: "Sint Maarten", phonePrefix: "+1 721"},{code: "SK", name: "Slovaquie", phonePrefix: "+421"},{code: "SI", name: "Slovénie", phonePrefix: "+386"},{code: "SO", name: "Somalie", phonePrefix: "+252"},{code: "SD", name: "Soudan", phonePrefix: "+249"},{code: "SS", name: "Soudan du Sud", phonePrefix: "+211"},{code: "LK", name: "Sri Lanka", phonePrefix: "+94"},{code: "SE", name: "Suède", phonePrefix: "+46"},{code: "CH", name: "Suisse", phonePrefix: "+41"},{code: "SR", name: "Suriname", phonePrefix: "+597"},{code: "SJ", name: "Svalbard Et Jan Mayen", phonePrefix: "+47"},{code: "SZ", name: "Swaziland", phonePrefix: "+268"},{code: "SY", name: "Syrie", phonePrefix: "+963"},{code: "TJ", name: "Tadjikistan", phonePrefix: "+992"},{code: "TW", name: "Taiwan", phonePrefix: "+886"},{code: "TZ", name: "Tanzanie", phonePrefix: "+255"},{code: "TD", name: "Tchad", phonePrefix: "+235"},{code: "TF", name: "Terres Australes et Antarctiques Françaises", phonePrefix: "+33"},{code: "IO", name: "Territoire Britannique de l'Océan Indien", phonePrefix: "+246"},{code: "TH", name: "Thaïlande", phonePrefix: "+66"},{code: "TL", name: "Timor oriental", phonePrefix: "+670"},{code: "TG", name: "Togo", phonePrefix: "+228"},{code: "TK", name: "Tokelau", phonePrefix: "+690"},{code: "TO", name: "Tonga", phonePrefix: "+676"},{code: "TT", name: "Trinité-et-Tobago", phonePrefix: "+1 868"},{code: "TN", name: "Tunisie", phonePrefix: "+216"},{code: "TM", name: "Turkménistan", phonePrefix: "+993"},{code: "TR", name: "Turquie", phonePrefix: "+90"},{code: "TV", name: "Tuvalu", phonePrefix: "+688"},{code: "UA", name: "Ukraine", phonePrefix: "+380"},{code: "UY", name: "Uruguay", phonePrefix: "+598"},{code: "VU", name: "Vanuatu", phonePrefix: "+678"},{code: "VA", name: "Vatican", phonePrefix: "+379"},{code: "VE", name: "Venezuela", phonePrefix: "+58"},{code: "VN", name: "Viet Nam", phonePrefix: "+84"},{code: "WF", name: "Wallis-et-Futuna", phonePrefix: "+681"},{code: "YE", name: "Yémen", phonePrefix: "+967"},{code: "ZM", name: "Zambie", phonePrefix: "+260"},{code: "ZW", name: "Zimbabwe", phonePrefix: "+263"},],
passengerRegexValidation: "^[- 'A-Za-z\u00c0\u00c1\u00c2\u00c3\u00c4\u00c5\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00c6\u00e6\u00df\u00c8\u00c9\u00ca\u00cb\u00e8\u00e9\u00ea\u00eb\u00cc\u00cd\u00ce\u00cfI\u0130\u00ec\u00ed\u00ee\u00ef\u0131i\u0152\u0153\u00d2\u00d3\u00d4\u00d5\u00d6\u00d8\u00f8\u00f2\u00f3\u00f4\u00f5\u00f6\u00f8\u00d9\u00da\u00db\u00dc\u00f9\u00fa\u00fb\u00fc\u0178\u00dd\u00fd\u00ff\u00c7\u00e7\u00d1\u00f1\u00d0\u00fe\u00de\u00b5\u0160\u0161Ss\u015e\u015fG\u011eg\u011f\u0192]{2,}$",
addressRegexValidation: "^[-/ ,\.'A-Za-z\u00c0\u00c1\u00c2\u00c3\u00c4\u00c5\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00c6\u00e6\u00df\u00c8\u00c9\u00ca\u00cb\u00e8\u00e9\u00ea\u00eb\u00cc\u00cd\u00ce\u00cfI\u0130\u00ec\u00ed\u00ee\u00ef\u0131i\u0152\u0153\u00d2\u00d3\u00d4\u00d5\u00d6\u00d8\u00f8\u00f2\u00f3\u00f4\u00f5\u00f6\u00f8\u00d9\u00da\u00db\u00dc\u00f9\u00fa\u00fb\u00fc\u0178\u00dd\u00fd\u00ff\u00c7\u00e7\u00d1\u00f1\u00d0\u00fe\u00de\u00b5\u0160\u0161Ss\u015e\u015fG\u011eg\u011f\u0192\\d]{2,50}$",
imagePath: '/images/',
dateFormat: 'UTC:dd/mm/yyyy',
isAppCheckInActiveByConfig: true,
isVisibleTouchpointPartitionTv19: true,
isVisibleTouchpointPartitionTv20: true,
isVisibleTouchpointPartitionTv21: true,
isVisibleTouchpointInRegisterPage: true,
isNewsletterVisible: true,
recaptchaSiteKey: '6LcV43EUAAAAAIPqczsFc3PI5dUEZI8EM_NRMXXT',
brandedImagePath: '/images/onefront/bluestone/GV/',
isManageMyBookingAvailable: true,
loginName: '',
loginError: '',
firstLogin: false,
isCarsActive: true
};   
Odigeo.Membership = {
enabledSpecialPrimeWidgets: true,
isShowMemberhsipAutoRenewal: false,
isMembershipPrimePaymentD: false,
isMembershipProductEnabled: true
}           
Odigeo.SessionScope = {
oneFrontVersion: '1.417.0',
flow: 'desktop',
hasMktPortal: 'true',
mktPortal: 'jetcost',
entryPoint: 'secure',
isSecure: '',
flowProduct: 'flights',
sortCriteria: 'MINIMUM_PURCHASABLE_MEMBERSHIP_PRICE',
brand: 'GV',
website: 'GOFR',
isMeta: true,
pluralRules: [/^\s*((0|1))\s*$/,/^\s*(\d+)\s*$/,/.*/],
interfaceCode: '16',
cosearchLibUrl: {
none: null,
old: '//cosearch.govoyages.com/servlet/api/comparesite/v1.js',
test: ''
},
visitId: '61414596051',
dynPackMode: 'GO',
dynPackUrlBase: 'http://booking.govoyages.com/search.aspx',
dynpackEnabled: 'true',
intermediatePageEnabled: 'true',
openNotification: true,
idpart: '19309',
isBookingXSWhiteLabel: false,
websiteDateFormats: {
itineraryDetailsDateFormatMobile: "UTC:dd mmm",
itineraryDetailsTimeFormatMobile: "UTC:HH:MM",
searchSummaryDateFormat: "UTC:d-mmm",
searchSummaryHeaderMobile: "ddd, dd/mm",
dialogDateExpireErrorCallUsFormat: "UTC:ddd d mmm"
},
tmSettings: {
siteId: '7',
client: 'govoyage',
intentMedia: {
enabled: 'true',
mobile: 'false'
}
},
tagCommanderScriptBody: '//cdn.tagcommander.com/4250/tc_eDreamsODIGEO_21.js',
userData: {},
tmParam: {
page_url: 'desktop.govoyages.com',
criteo_id: '834',
site_type: 'D',
device: 'D',
userMemberId: '',
language: 'fr',
market: 'FR',
usabilla_button_active: 'true'
},
social: {
facebookAppId: '1535001026732705',
googleLoginClientId: '766446582686-5ao0cb27gc1h8cgcl5fmuska3mthvl1t.apps.googleusercontent.com'
}

,
appCheckInDesktopSettings: {
url: 'https://cl.exct.net/subscribe.aspx',
market: 'France',
pos: 'govoyages.fr',
lid: '186',
mid: '7210125',
brand: 'GoVoyages'
}

,
gpt: {
pageUrl: 'http://www.govoyage.fr/',
domainConfig: {
siteId: 'fr',
domain: 'govoyage.fr'
},
targetings: {
site: 'A',
isWL: 'false',
mktPortal: 'GOV_FR'
},
slots: []
},
ads: {
pageOptions: {
pubId: 'odigeo-all-fr',
query: 'vols',
titleBold: true,
rolloverLinkUnderline: true,
rolloverLinkColor: '#EBEBEB',
channel: 'GO_FR_VOLS_OF',
hl: 'fr'
},
style: {
colorTitleLink: '#045EBB',
colorDomainLink: '#044D98',
colorBorder: '#EBEBEB'
},

travelAudience: {
flights: {
account: '30061',
ad_position: '1'
},
dp: {
account: '30062',
ad_position: '1'
},
style: {
ad_width: '700',
ad_height: '365',
color_text: '#433f33',
ad_type: 'text/swf',
color_headline: '#206500',
color_price: '#1a1a1aa7',
color_border: '#a5cd38',
color_url: '#206500',
color_bg: '#ffffff',
border_radius: '3px',
color_hover: 'linear-gradient(90deg,#d4edff,rgba(255,255,255,1))'
}
},

types: {

'flights': {
id: 'flights',
query: 'vols',
channel: 'GO_FR_VOLS_OF'
},
'dp-hotels': {
id: 'dp-hotels',
query: 'hôtels',
channel: 'GO_FR_DP_Hotels'
},
'dp-flights': {
id: 'dp-flights',
query: 'vols',
channel: 'GO_FR_DP_Flights'
}
}
}

};  
Odigeo.WebsiteConfig = {
seatMapSelectionSettings: {
seatMapMaxNumberOfRetries: '1'
}
};                        
Odigeo.UIElements.translations = {
err0: {
header: "La connexion a \u00E9t\u00E9 perdue",
content: "Il semble que la connexion a \u00E9t\u00E9 interrompue. Veuillez relancer votre recherche.",
button: "Veuillez r\u00E9essayer",
link: "https:\/\/www.govoyages.com\/?noext=1&landingPageType=PASSENGER&locale=fr_FR&mktportal=jetcost&searchId=55923407515&searchMainProductTypeName=FLIGHT&testToken=1%231769951880-2%23146-3%234012-4%2333231-5%23542439174-6%2334362-7%23108487-8%2321241867293-9%2340983293347-10%2311397618687-11%2322215798871-12%2340626740826-13%2339739419014-14%2346525051812-15%2388588740463-16%2348016225072-17%2352721078370-18%2389369785565-19%2349587740256-20%2389350815336-21%2358096230788-22%2355778047071&testTokenDate=2019-05-06T17%3A09%3A33&fareItineraryKey=11,1A&segmentKey0=0,AF7654&segmentKey1=1,AF7491"
},
err404: {
header: "Nous sommes d\u00E9sol\u00E9s.",
content: "D\u00E9sol\u00E9 ! La page recherch\u00E9e ne peut pas \u00EAtre trouv\u00E9e."
},
err500: {
header: "D\u00E9sol\u00E9 !",
content: "<p>D\u00E9sol\u00E9 mais cette page n\'est pas disponible pour le moment.<\/p><p> Nous vous invitons donc \u00E0 r\u00E9essayer ult\u00E9rieurement ou \u00E0 acc\u00E9der \u00E0 notre site depuis un ordinateur.<\/p>",
button: "Afficher la version classique de ce site",
link: "https:\/\/www.govoyages.com\/?noext=1&landingPageType=PASSENGER&locale=fr_FR&mktportal=jetcost&searchId=55923407515&searchMainProductTypeName=FLIGHT&testToken=1%231769951880-2%23146-3%234012-4%2333231-5%23542439174-6%2334362-7%23108487-8%2321241867293-9%2340983293347-10%2311397618687-11%2322215798871-12%2340626740826-13%2339739419014-14%2346525051812-15%2388588740463-16%2348016225072-17%2352721078370-18%2389369785565-19%2349587740256-20%2389350815336-21%2358096230788-22%2355778047071&testTokenDate=2019-05-06T17%3A09%3A33&fareItineraryKey=11,1A&segmentKey0=0,AF7654&segmentKey1=1,AF7491"
},
errCookies: {
header: "Veuillez activer les cookies pour continuer",
content: "Pour continuer \u00E0 utiliser ce site, veuillez activer les cookies sur votre navigateur Internet.",
button: "Rafra\u00EEchir"
},
errSessionExpired: {
header: "Votre recherche a expir\u00E9",
content: "Veuillez r\u00E9essayer ou appelez-nous au <span class=\"odf-text-info\"><b>0892 68 64 60<\/b><\/span> pour r\u00E9server par t\u00E9l\u00E9phone.",
suggestion: "",
buttons: [
{
title: "Essayer avec d\'autres dates",
subtitle: ""
},
{
title: "Relancer la m\u00EAme recherche",
subtitle: ""
}
],
flightsTo: "\u00E0",
flightsDep: "D\u00E9part",
flightsRet: "Retour",
flightsFor: "pour",
flightsAdults: "adultes",
flightsAdult: "adulte",
flightsChildren: "enfants",
flightsChild: "enfant",
flightsInfants: "b\u00E9b\u00E9s",
flightsInfant: "b\u00E9b\u00E9",
flightsAnd: "et",
dateFormat: "UTC:d-mmm",
DpCheckInDate: "Arriv\u00E9e",
DpCheckOutDate: "D\u00E9part",
flightTitle: "Vol",
hotelTitle: "H\u00F4tel"
},
errSearchExpired: {
header: "Votre recherche a expir\u00E9",
content: "Ce probl\u00E8me peut survenir si vous lancez plusieurs recherches en m\u00EAme temps. Veuillez fermer les onglets concern\u00E9s et relancer votre recherche.",
suggestion: "",
buttons: [
{
title: "Essayer avec d\'autres dates",
subtitle: ""
},
{
title: "Relancer la m\u00EAme recherche",
subtitle: ""
}
]
},
alertValidationError: {
header: "Une erreur est survenue",
content: "Un probl\u00E8me est survenu lors de la saisie de donn\u00E9es. Veuillez rafra\u00EEchir la page et recommencer l\u2019op\u00E9ration.",
button: "Actualiser"
},
errBrokenFlow: {
header: "Une erreur est survenue",
content: "Il semble que votre session a \u00E9t\u00E9 interrompue. Veuillez relancer votre recherche.",
suggestion: "",
buttons: [
{
title: "Essayer avec d\'autres dates",
subtitle: ""
},
{
title: "Relancer la m\u00EAme recherche",
subtitle: ""
}
]
},
errBrokenFlowAccommodationPostBooking: {
header: "Une erreur est survenue",
content: "Il semble que votre session a \u00E9t\u00E9 interrompue. Veuillez relancer votre recherche.",
button: "R\u00E9essayer"
},
errMembershipSubscription: {
creatingAccount: {
headerTitle: "Erreur lors de la cr\u00E9ation de votre compte",
description: "Une erreur est survenue lors de la cr\u00E9ation de votre compte",
primaryButton: "Poursuivre la r\u00E9servation sans abonnement",
secondaryButton: ""
},
memberExists: {
headerTitle: "Vous \u00EAtes d\u00E9j\u00E0 membre GO Prime",
description: "Cet e-mail appartient d\u00E9j\u00E0 \u00E0 un compte GO Prime, veuillez v\u00E9rifier les informations saisies.",
primaryButton: "Connectez-vous et acc\u00E9dez \u00E0 vos avantages Prime",
secondaryButton: ""
}
},
saveConfirmation: {
title: "information",
content: "Voulez-vous enregistrer les modifications ?",
buttons: [
{
title: "Annuler les modfications"
},
{
title: "Enregistrer les modifications."
}
]
},
myinfoDeleteConfirmation: {
title: "Information",
content: "Etes-vous s\u00FBr de vouloir supprimer ce passager ?",
buttons: [
{
title: "Annuler"
},
{
title: "Supprimer le passager"
}
]
},
callUsDialog: {
header: "Appelez-nous vite\u00A0!",
content: {
hours_title: "Pour nous contacter",
hours: "24h sur 24, 7 jours sur 7.",
price: "Service 0,80 \u20AC\/min + prix appel",
tel_text: "Pouvons-nous vous aider ?"
},
button: ""
},
deleteCard: {
header: "Supprimer une carte de cr\u00E9dit ou de d\u00E9bit",
buttons: [
{
title: "Supprimer la carte"
},
{
title: "Garder la carte"
}
]
},
datepicker: {
year: "",
month: "",
day: ""
},
ageValidationError: {
header: "Information",
content_baby: "Les b\u00E9b\u00E9s \u00E2g\u00E9s de plus de 23 mois sont consid\u00E9r\u00E9s comme des enfants. Merci d\'effectuer une nouvelle recherche ou de modifier vos crit\u00E8res.",
content_kid: "Merci de v\u00E9rifier vos crit\u00E8res de recherche",
button: "Modifier la recherche"
},
waitings: {
multipleDates: "Dates multiples",
multipleCities: "Multidestination"
},
paymentRetry: {
retrySearch: "Retour \u00E0 la recherche"
},
ubulayer: {
title: "Avant de terminer votre achat",
btn_check_ccinfo: "Choisissez une autre carte",
btn_book_now: "Achever la commande"
},
upsellLayer: {
header: "Merci pour votre r\u00E9servation\u00A0!",
title: "Vous pouvez maintenant terminer votre voyage \u00E0 destination de",
titleSecond: "",
bookingComUrl: "https:\/\/booking.com\/_23279c97bc697cf?checkin_monthday=$checkin_monthday$&checkin_year_month=$checkin_year_month$&checkout_monthday=$checkout_monthday$&checkout_year_month=$checkout_year_month$&order=price_for_two&iata=$iata$",
hotelsBannerUrl: "http:\/\/hotel.govoyages.com\/searchresults.html?aid=358748&label=gvy-link-fr-layer_A-conf-pc-of&lang=fr&selected_currency=EUR&iata=$iata$&iata_orr=1&checkin_monthday=$checkin_monthday$&checkin_year_month=$checkin_year_month$&checkout_monthday=$checkout_monthday$&checkout_year_month=$checkout_year_month$",
carsBannerUrl: "https:\/\/voiture.govoyages.com\/SearchLoader.do?preflang=fr&from=$iataCodeFrom$&to=$iataCodeTo$&puDay=$puDay$&puMonth=$puMonth$&puYear=$puYear$&doDay=$doDay$&doMonth=$doMonth$&doYear=$doYear$&puHour=$puHour$&puMinute=$puMinute$&doHour=$doHour$&doMinute=$doMinute$&driversAge=25&prefcurrency=EUR&adplat=emerginglayer-flights&adcamp=pc&affiliateCode=govoyages&ng=$nPassengers$&adco=$pnr$",
gtBannerUrl: "https:\/\/transferts.govoyages.com\/fr-fr\/?currency=EUR&ref=govoyages&campaign=gov-fr-fr-$campaign$-pc&mode=$mode$&num_passengers=$travellers$&start_address=$airportCode$&pickup_datetime=$checkinDate$&return_pickup_datetime=$checkoutDate$",
hasGt: true,
showCarsFirst: "",
},
xsellBaseDeeplinksUrl: {
cartrawler: "https:\/\/voiture.govoyages.com\/%brand$s\/%language$s\/book?pickupIATACode=%arrivalIataCode$s&returnIATACode=%departureIataCode$s&residenceID=%clientResidenceId$s&age=%clientAge$s&pickupDateTime=%arrivalDateTime$s&returnDateTime=%departureDateTime$s&currency=%currency$s&passNum=%nOfPassengers$s&sourceCountry=%sourceCountry$s&destinationCountry=%destinationCountry$s&oneWay=%oneWay$s&nOfBaggages=%nOfBaggages$s",
},
confirmationWidgets: {
cars: {
url: "https:\/\/voiture.govoyages.com\/SearchLoader.do?from=%1$s&to=%1$s&puDay=%2$s&puMonth=%3$s&puYear=%4$s&puHour=%5$s&puMinute=%6$s&doDay=%7$s&doMonth=%8$s&doYear=%9$s&doHour=%10$s&doMinute=%11$s&driversAge=25&preflang=fr&prefcurrency=EUR&adcamp=flightsof_B&adplat=widgetsearch&adco=%12$s&ng=%13$s",
homeUrl: "",
},
hotels: {
url: "http:\/\/hotel.govoyages.com\/searchresults.html?aid=358748&label=gvy-link-fr-layer_A-conf-pc-of&lang=fr&selected_currency=EUR&iata=%1$s&iata_orr=1&checkin_monthday=%2$s&checkin_year_month=%3$s&checkout_monthday=%4$s&checkout_year_month=%5$s"
}
},
confirmationTripDetailsMessages: {
earlyMessage: {
url: "https:\/\/hotel.govoyages.com\/searchresults.html?aid=358748&label=gvy-link-fr-confirmation_early_banner-conf-pc-of&lang=fr&selected_currency=EUR&iata=%1$s&iata_orr=0&checkin_monthday=%2$s&checkin_year_month=%3$s&checkout_monthday=%4$s&checkout_year_month=%5$s",
},
expediaEarlyMessage: {
url: "http:\/\/widgets.hotels.com\/airport_search.do?widgetTarget=XSellWidgetPlace&airportArrival=%1$s&widgetID=%2$s&q-check-in=%3$s&q-check-out=%4$s&q-rooms=%5$s&locale=fr_FR&cur=%6$s&wapb3=|c.505017|l.fr_FR|t.site|s.banner_cp&flightNumOfPassengers=%7$s&flightOutboundDate=%8$s&flightInboundDate=%9$s&flightAirportOrigin=%10$s&flightPurchaseDate=%11$s&token=%12$s"
}
},
myTripsWidgets: {
cars: {
url: "http:\/\/voiture.govoyages.com\/SearchLoader.do?from=%1$s&to=%1$s&puDay=%2$s&puMonth=%3$s&puYear=%4$s&puHour=%5$s&puMinute=%6$s&doDay=%7$s&doMonth=%8$s&doYear=%9$s&doHour=%10$s&doMinute=%11$s&driversAge=25&preflang=fr&prefcurrency=EUR&adcamp=mytrips_B&adplat=widgetsearch&adco=%12$s&ng=%13$s",
},
hotels: {
url: "http:\/\/hotel.govoyages.com\/searchresults.html?aid=358748&label=gvy-link-fr-layer_A-conf-pc-of&lang=fr&selected_currency=EUR&iata=%1$s&iata_orr=1&checkin_monthday=%2$s&checkin_year_month=%3$s&checkout_monthday=%4$s&checkout_year_month=%5$s"
}
},
fareFantasy: {
timeout: "2000",
lessInfo: "Moins d\'infos",
moreInfo: "Voir plus"
},
xsellHomePage: {
homeHotelTabUrl: "",
hasHotelTab: false
},
xsellIntermediatePage: {
timeout: "15000",
timeoutMktPortalTelesales: 25000,
minResults: "3",
roomsToShowOnLanding: "5",
roomsToShowOnMore: "5",
boardTypes: {
RO: "",
HB: "Demi-pension",
AI: "Tout compris",
BB: "Petit-d\u00E9jeuner inclus",
FB: "Pension compl\u00E8te",
UN: "",
SC: "Coin kitchenette"
},
mapDiscounts: {
specialDiscount: "Offre sp\u00E9ciale",
productMessagePlus: "VOL + H\u00D4TEL",
productMessageAdd: "AJOUTER H\u00D4TEL D\u00C8S"
},
removeHotel: {
title: 'Vous \u00EAtes s\u00FBr ?',
subtitle: 'Vous avez trouv\u00E9 un super h\u00F4tel \u00E0 un prix incroyable.',
button1: 'Supprimer l\u2019h\u00F4tel de la r\u00E9servation',
button2: 'Garder cette super offre',
alternative: 'Ou vous pouvez',
changeHotel: 'choisir un autre h\u00F4tel',
loadingMessage: 'En cours... D\u00E9couvrez plus d\'h\u00F4tels apr\u00E8s cette r\u00E9servation.'
},
noHotelsResults: {
title: 'Nous sommes d\u00E9sol\u00E9s',
subtitle: 'Nous n\'avons trouv\u00E9 aucun h\u00F4tel pour cette recherche',
button1: '',
button2: 'Continuer ma r\u00E9servation'
},
results: {
singularNight: '1 nuit par passager',
pluralNight: 'Par personne pour %1$s nuits'
}
},
bookingHotelsUrl: {
deeplink: "http:\/\/hotel.govoyages.com\/searchresults.html?aid=358748;iata=%1$s;iata_orr=1;checkin_monthday=%2$s;checkin_year_month=%3$s;checkout_monthday=%4$s;checkout_year_month=%5$s;selected_currency=EUR;lang=fr"
},
expediaHotelsUrl: {
deeplink: "http:\/\/widgets.hotels.com\/airport_search.do?widgetTarget=XSellWidgetPlace&airportArrival=%1$s&widgetID=%2$s&q-check-in=%3$s&q-check-out=%4$s&q-rooms=%5$s&locale=fr_FR&cur=%6$s&flightNumOfPassengers=%7$s&flightOutboundDate=%8$s&flightInboundDate=%9$s&flightAirportOrigin=%10$s&flightPurchaseDate=%11$s&token=%12$s"
},
expediaHotels: {
id: "83",
key: "fttda4q5u0qhg",
deeplink: "http:\/\/widgets.hotels.com\/airport_search.do?widgetTarget=XSellWidgetPlace&airportArrival=%1$s&widgetID=%2$s&q-check-in=%3$s&q-check-out=%4$s&q-rooms=%5$s&locale=fr_FR&cur=%6$s&wapb3=|c.505017|l.fr_FR|t.site|s.banner_mb&flightNumOfPassengers=%7$s&flightOutboundDate=%8$s&flightInboundDate=%9$s&flightAirportOrigin=%10$s&flightPurchaseDate=%11$s&token=%12$s",
emlConfirmation: "http:\/\/widgets.hotels.com\/airport_search.do?widgetTarget=XSellWidgetPlace&airportArrival=$airportArrival$&widgetID=$widgetId$&q-check-in=$checkIn$&q-check-out=$checkOut$&q-rooms=$rooms$&locale=fr_FR&cur=$currency$&wapb3=|c.505017|l.fr_FR|t.site|s.layer&flightNumOfPassengers=$passengers$&flightOutboundDate=$departureDate$&flightInboundDate=$arrivalDate$&flightAirportOrigin=$airportOrigin$&flightPurchaseDate=$purchaseDate$&token=$token$"
},
myTripsXsellProducts: {
cars: {
title: "Vous cherchez une voiture de location ?",
desc: "De grandes marques \u00E0 petits prix. R\u00E9servez moins cher maintenant.",
button: "Voir les voitures disponibles",
},
hotels: {
title: "Jusqu\'\u00E0 - 40 % sur tous nos meilleurs h\u00F4tels",
bannerLink: "http:\/\/hotel.govoyages.com\/searchresults.html?aid=358748;iata=%1$s;iata_orr=1;checkin_monthday=%2$s;checkin_year_month=%3$s;checkout_monthday=%4$s;checkout_year_month=%5$s;selected_currency=EUR;lang=fr;label=gvy-link-fr-mytrips_banner-pc-conf-of",
bannerDetailsLink: "http:\/\/hotel.govoyages.com\/searchresults.html?aid=358748;iata=%1$s;iata_orr=1;checkin_monthday=%2$s;checkin_year_month=%3$s;checkout_monthday=%4$s;checkout_year_month=%5$s;selected_currency=EUR;lang=fr;label=gvy-link-fr-mytrips_banner_A-pc-conf-of",
desc: "Votre r\u00E9servation de vol vous donne acc\u00E8s \u00E0 des offres d\'h\u00F4tels exclusives",
button: "Voir les offres",
},
groundTransport: {
bannerLink: "https:\/\/transferts.govoyages.com\/fr-fr\/?currency=EUR&ref=govoyages&campaign=gov-fr-fr-%1$s-pc&mode=%2$s&num_passengers=%3$s&start_address=%4$s&pickup_datetime=%5$s&return_pickup_datetime=%6$s",
title: "Transferts a\u00E9roport rapides et \u00E9conomiques",
desc: "R\u00E9servez maintenant pour un trajet agr\u00E9able en toute simplicit\u00E9",
button: "R\u00E9server transfert",
detailsLink: ""
}
},
myTripsXsellParameters: {
gtActive: true
},
dynpackProduct: {
pricediscount: {
titleCms: "Qu\'est ce que la r\u00E9duction Vol + H\u00F4tel\u00A0?",
infoCms: "Cette r\u00E9duction exclusive \u00E0 GO Voyages se base sur la comparaison avec le prix du m\u00EAme vol et m\u00EAme h\u00F4tel r\u00E9serv\u00E9s s\u00E9par\u00E9ment. Si cette combinaison vous int\u00E9resse, d\u00E9p\u00EAchez-vous, car la <b>disponibilit\u00E9 est limit\u00E9e<\/b>.",
perPassenger: "Par personne",
},
facilities: {
freebies: "Services gratuits",
roomServices: "Chambres",
hotelServices: "Services h\u00F4teliers",
wellness: "Bien-\u00EAtre",
foodPlace: "Restaurant\/bar",
technology: "Technologie",
transport: "Mobilit\u00E9 et transports",
sports: "Sports et loisirs",
entertainment: "Divertissement",
general: "G\u00E9n\u00E9ral",
facilities: "Installations",
childrenServices: "Installations et services pour enfants",
business: "Affaires"
},
services: {
wifi: "Wi-fi gratuit",
parking: "Parking gratuit"
},
noResults: {
resetBtn: "Modifiez vos crit\u00E8res de recherche",
labelops: "V\u00E9rifiez vos crit\u00E8res de recherche",
labelnoresults: "Il semble qu\'il n\'y ait pas de vol entre ces deux villes \u00E0 ces dates. V\u00E9rifiez les a\u00E9roports de d\u00E9part et de destination, ainsi que les dates, ou modifiez vos crit\u00E8res de recherche."
},
roomSelection: {
roomleftLast: "Derni\u00E8re chambre \u00E0 ce prix",
roomleftAvailable: "%1$s chambres \u00E0 ce prix",
priceDiscountTooltip: "\u00C9conomisez %1$s (%2$s par personne), en r\u00E9servant un Vol + H\u00F4tel !"
},
customFacilityGroups: {
AC: "Climatisation",
BAR_RESTAURANT: "Bar ou restaurant",
LIFT: "Ascenseur",
FREE_AIRPORT_SHUTTLE: "Navette a\u00E9roport gratuite",
FREE_PARKING: "Parking gratuit",
FREE_WIFI: "Wi-fi gratuit",
GAY_FRIENDLY: "Gay-friendly",
GYM: "Salle de sport",
HANDICAPPED: "Acc\u00E8s handicap\u00E9s",
HEATING: "Chauffage",
PETS_ALLOWED: "Animaux accept\u00E9s",
ROOM_SERVICE: "Service de chambre",
SPA_SAUNA: "Spa ou sauna",
SWIMMING_POOL: "Piscine"
},
accommodationTypes: {
APARTAMENT: "appartement",
BED_AND_BREAKFAST: "bed and breakfast",
GUEST_HOUSE: "chambre d\'h\u00F4tes",
HOSTEL: "auberge de jeunesse",
HOTEL: "h\u00F4tel",
MOTEL: "motel",
RESIDENCE: "r\u00E9sidence",
RESORT: "complexe h\u00F4telier",
RYOKAN: "ryokan",
UNKNOWN: "Autre"
},
suggested: {
mainBtn: {
available: "R\u00E9server",
unavailable: "Non disponible"
}
},
mapButtonControls: {
hidePrice: "Cacher les prix",
showPrice: "Montrer les prix"
},
sorting: {
desktop: {
BEST_VALUE_FOR_CLIENT: "Meilleures ventes",
BEST_SELLING: "Meilleures ventes",
BEST_PRICE: "Prix",
CLOSE_TO_LOCATION: "Distance %1$s",
DISCOUNT_PERCENTAGE: "Meilleures promos"
},
mobile: {
BTN: "",
BEST_SELLING: "",
BEST_VALUE_FOR_CLIENT: "Recommand\u00E9s",
BEST_PRICE: "",
CLOSE_TO_LOCATION: "",
DISCOUNT_PERCENTAGE: "Meilleures promos"
}
},
filterTags: {
PRICE_RANGE: "Gamme de prix",
GUEST_REVIEWS: "Notes des h\u00F4tes",
DISTANCE_CENTER: "Situation",
HOTEL_NAME: "Nom de l\u2019h\u00F4tel",
GUEST_RATING: "Nombre d\'\u00E9toiles",
OUR_SELECTION: "Offres sp\u00E9ciales",
NEIGHBOURHOOD: "Quartier",
AC: "Climatisation",
BAR_RESTAURANT: "Bar ou restaurant",
LIFT: "Ascenseur",
FREE_AIRPORT_SHUTTLE: "Navette a\u00E9roport gratuite",
FREE_PARKING: "Parking gratuit",
FREE_WIFI: "Wi-fi gratuit",
GAY_FRIENDLY: "Gay-friendly",
GYM: "Salle de sport",
HANDICAPPED: "Acc\u00E8s handicap\u00E9s",
HEATING: "Chauffage",
PETS_ALLOWED: "Animaux accept\u00E9s",
ROOM_SERVICE: "Service de chambre",
SPA_SAUNA: "Spa ou sauna",
SWIMMING_POOL: "Piscine",
APARTAMENT: "appartement",
BED_AND_BREAKFAST: "bed and breakfast",
GUEST_HOUSE: "chambre d\'h\u00F4tes",
HOSTEL: "auberge de jeunesse",
HOTEL: "h\u00F4tel",
MOTEL: "motel",
RESIDENCE: "r\u00E9sidence",
RESORT: "complexe h\u00F4telier",
RYOKAN: "ryokan",
UNKNOWN: "Autre",
CLOSE_TO_LOCATION: "Distance du centre-ville de %1$s"
},
boardType: {
RO: '',
BB: 'Petit-d\u00E9jeuner inclus',
HB: 'Demi-pension',
AI: 'Tout compris',
FB: 'Pension compl\u00E8te',
SC: 'Coin kitchenette'
},
suggestions: {
priceRangeSuggestion: {
title: "Un petit plus ?",
content: "Voir plus d\u2019h\u00F4tels pour juste <b>%1$s de plus<\/b>",
},
distanceToPoiSuggestion: {
title: "H\u00F4tels \u00E0 proximit\u00E9",
content: "\u00C9largir la recherche dans <b>un rayon de %1$s<\/b>",
},
categorySuggestion: {
title: "Faites-vous plaisir !",
content: "Jetez un \u0153il aux <b>h\u00F4tels %1$s \u00E9toiles<\/b>",
},
tripDatesSuggestion: {
title: "Vos dates sont flexibles ?",
content: "Voyagez le <b>%2$s %1$s<\/b> et \u00E9conomisez !",
}
},
waiting: {
airplane: "",
hotel: "",
credential_vacations: "",
},
},
unl: {
lightboxTextsVelocityRules: {
headerTitle: "Impossible de poursuivre cette r\u00E9servation avec GO Prime",
description: "Nous ne pouvons pas appliquer la r\u00E9duction GO Prime. Vous pouvez compl\u00E9ter cette r\u00E9servation sans la r\u00E9duction Prime.",
primaryButton: "Continuer",
secondaryButton: ""
}
},
membershipManager: {
lightboxTexts: {
headerTitle: "Impossible de r\u00E9silier votre abonnement",
description: "Nous ne pouvons pas r\u00E9silier votre abonnement GO Prime pour le moment. Veuillez r\u00E9essayer ult\u00E9rieurement ou contacter le Service client.",
primaryButton: "Veuillez r\u00E9essayer ult\u00E9rieurement",
secondaryButton: ""
}
},
alreadyConfirmed: {
title: "Nous sommes d\u00E9sol\u00E9s, vous ne pouvez pas refaire la m\u00EAme r\u00E9servation",
desc: "Vous avez d\u00E9j\u00E0 effectu\u00E9 une r\u00E9servation pour ce vol. Veuillez consulter vos e-mails, vous allez recevoir une notification concernant le statut de votre r\u00E9servation. \nPour toute nouvelle r\u00E9servation, vous serez de nouveau factur\u00E9. Pour r\u00E9server un autre vol, merci de faire une nouvelle recherche.",
button: "Nouvelle recherche"
},
flightsManager: {
allAirports: "tous les a\u00E9roports",
multiple_cityText: "",
another_city: ""
},
registerWaiting: {
content: "Enregistrement..."
},
charter: {
disclaimer_content: "En recherchant pour vous, les meilleures offres au plus bas prix, nous avons trouv\u00E9 ce vol, MAIS :",
disclaimer_content_title: "Il s\'agit d\'un vol sp\u00E9cial",
disclaimer_content_item1: "Il n\'a pas lieu \u00E0 la date s\u00E9lectionn\u00E9e.",
disclaimer_content_item2: ""
},
disclaimerPayment: {
content: ""
},
alertsMessages: {
nodirectflights: "Aucun vol direct trouv\u00E9. R\u00E9sultats avec escale(s).",
noseats_selected_flight: "Il n\'y a plus qu\'un si\u00E8ge disponible sur ce vol. Voici des vols pour deux."
},
holidayLegends: {
country: "Jour f\u00E9ri\u00E9 en France",
region: "Jour f\u00E9ri\u00E9 dans une partie de la France"
},
faresInCalendar: {
cheaper: "Moins cher",
expensive: "Plus cher",
departureAmount: "Afficher les prix vol aller",
returnAmount: "Afficher les prix vol retour",
},
persuasiveMessages: 
{
resultViewers: {
numViewers: {min: 100, max: 2000},
destination: '$searchParameters.searchSegments[0].destination.city',
firstResultPrice: '$firstResultPrice'
},
resultRandom: {
hours: {min: 6, max: 48},
firstResultPrice: '$firstResultPrice',
destination: '$searchParameters.searchSegments[0].destination.city'
},
payment: {
title: "Pourquoi attendre\u00A0?",
text: "C\'est l\'une des meilleures offres de la journ\u00E9e. R\u00E9servez maintenant\u00A0!",
topTitle: "",
topText: "<b>Pourquoi attendre ?<\/b> C\'est l\'une des meilleures offres de la journ\u00E9e. R\u00E9servez maintenant !",
default: "<b>Pourquoi attendre\u00A0?</b> C\'est l\'une des meilleures offres de la journ\u00E9e. R\u00E9servez maintenant\u00A0!"
},
passengersinfo: {
title: "Ne ratez pas cette offre\u00A0!",
text: "Les prix peuvent augmenter. Profitez-en avant qu\'il ne soit trop tard.",
default: "<b>Ne ratez pas cette offre\u00A0!</b> Les prix peuvent augmenter. Profitez-en avant qu\'il ne soit trop tard."
},
details: {
topTitle: "Ne ratez pas cette offre\u00A0!",
topText: "Les prix peuvent augmenter. Profitez-en avant qu\'il ne soit trop tard."
},
'results-viewers': {
numViewers: {min: 100, max: 2000},
destination: '$searchParameters.searchSegments[0].destination.city'
},
'latest-booking': {
firstResultPrice: '$firstResultPrice',
destination: '$searchParameters.searchSegments[0].destination.city'
},
'high-demand': {
destination: '$searchParameters.searchSegments[0].destination.city'
},
'sell-out': {
destination: '$searchParameters.searchSegments[0].destination.city',
hours: {min: 6, max: 48}
}
},
notifications: {
paxGeneralBody: "Qui part en voyage ?",
payGeneralBody: "Rappel : ",
paxSubtitleBody: "Nous ne pouvons pas bloquer ce prix sans vos coordonn\u00E9es.",
paySubtitleBody: "Nous ne pouvons garantir le prix qu\'une fois le paiement effectu\u00E9."
},
infocheckinpopup: {
title: "Demander les cartes d\'embarquement"
},
hotelResultsPhones: [
"0892 68 64 60"
]
};  
Odigeo.Utils.Currency.currencySign = '€';
Odigeo.Utils.Currency.currencyPosition = 'back';
Odigeo.Utils.Currency.decimalPlaces = 2;
Odigeo.Utils.Currency.decimalSeparator = ",";

Odigeo.Utils.Currency.thousandSeparator = " ";

Odigeo.Utils.Currency.currencySymbolPrefix = "";

Odigeo.Utils.Currency.currencyCode = "EUR";
Odigeo.Utils.Currency.spaceBetweenSignAndQuantity = true;
Odigeo.Utils.Currency.signPosition = "BEFORE";  
Odigeo.Utils.fromNow.i18n.aDayAgo = 'Il y a 1 jour';
Odigeo.Utils.fromNow.i18n.aFewSecondsAgo = 'Il y a quelques secondes';
Odigeo.Utils.fromNow.i18n.aMinuteAgo = 'Il y a 1 minute';
Odigeo.Utils.fromNow.i18n.aMonthAgo = 'Il y a 1 mois';
Odigeo.Utils.fromNow.i18n.anHourAgo = 'Il y a 1 heure';
Odigeo.Utils.fromNow.i18n.aYearAgo = 'Il y a 1 an';
Odigeo.Utils.fromNow.i18n.xDaysAgo = 'Il y a %1$s jours';
Odigeo.Utils.fromNow.i18n.xHoursAgo = 'Il y a %1$s heures';
Odigeo.Utils.fromNow.i18n.xMinutesAgo = 'Il y a %1$s minutes';
Odigeo.Utils.fromNow.i18n.xMonthsAgo = 'Il y a %1$s mois';
Odigeo.Utils.fromNow.i18n.xYearsAgo = 'Il y a %1$s ans';

Odigeo.Utils.formatDate.i18n.dayNames = Odigeo.Utils.days = ''.split(',');
Odigeo.Utils.formatDate.i18n.dayShortNames = Odigeo.Utils.daysShort = 'dim,lun,mar,mer,jeu,ven,sam'.split(',');
Odigeo.Utils.formatDate.i18n.monthNames = Odigeo.Utils.months = 'janvier,f\u00E9vrier,mars,avril,mai,juin,juillet,ao\u00FBt,septembre,octobre,novembre,d\u00E9cembre'.split(',');
Odigeo.Utils.formatDate.i18n.monthShortNames = Odigeo.Utils.monthsShort = 'janv.,f\u00E9vr.,mars,avr.,mai,juin,juil.,ao\u00FBt,sept.,oct.,nov.,d\u00E9c.'.split(',');
Odigeo.Utils.formatDate.i18n.startDay = Odigeo.Utils.startDay = '1';

Odigeo.Utils.calendarHolidays.countryHolidays = '01\/11\/18,11\/11\/18,25\/12\/18,01\/01\/19,22\/04\/19,01\/05\/19,08\/05\/19,30\/05\/19,10\/06\/19,14\/07\/19,15\/08\/19,01\/11\/19,11\/11\/19,25\/12\/19,01\/01\/20,13\/04\/20,01\/05\/20,08\/05\/20,21\/08\/20,01\/06\/20,14\/07\/20,15\/08\/20,01\/11\/20,11\/11\/20,25\/12\/20'.trim().length > 0 ?  '01\/11\/18,11\/11\/18,25\/12\/18,01\/01\/19,22\/04\/19,01\/05\/19,08\/05\/19,30\/05\/19,10\/06\/19,14\/07\/19,15\/08\/19,01\/11\/19,11\/11\/19,25\/12\/19,01\/01\/20,13\/04\/20,01\/05\/20,08\/05\/20,21\/08\/20,01\/06\/20,14\/07\/20,15\/08\/20,01\/11\/20,11\/11\/20,25\/12\/20'.split(',') : [];
Odigeo.Utils.calendarHolidays.regionHolidays = '26\/12\/18,19\/04\/19,26\/12\/19,10\/04\/20,26\/12\/20'.trim().length > 0 ? '26\/12\/18,19\/04\/19,26\/12\/19,10\/04\/20,26\/12\/20'.split(',') : [];  
Odigeo.Utils.sessionMaxInactiveIntervalInSeconds = '1200';
Odigeo.Utils.sessionLifeTime = '1200';
Odigeo.Utils.sessionTimerNagLongest = false;   
(function() {
'use strict';
Odigeo.UIElements.translations.errSessionExpiredCallUs = {
header: "Votre recherche pour %1$s a expir\u00E9",
headerMulti: "Votre recherche a expir\u00E9",
buttons: [
{ title: "Nouvelle recherche" },
{ title: "Relancer la recherche"}
],
footer: "Offres exclusives par t\u00E9l\u00E9phone",
subtext: "",
phone: "0892 68 64 60",
phoneHref: "",
hours: "",
charge: "Service 0,80 \u20AC\/min + prix appel",
and: "et",
adults: "$[_pl0(%1$s||1 adulte|%1$s adultes)]",
children: "$[_pl0(%1$s||1 enfant|%1$s enfants)]",
infants: "$[_pl0(%1$s||1 b\u00E9b\u00E9|%1$s b\u00E9b\u00E9s)]",
hotelTitle: "H\u00F4tel",
dateFormat: "UTC:ddd d mmm"
}
}());    
(function() {
'use strict';
Odigeo.AB.isTapToCallInAboutToExpiredAlertDesktop = false;
Odigeo.AB.isTapToCallInAboutToExpiredAlertMobile = false;
Odigeo.AB.isTapToCallInAboutToExpiredAlertDP = false;
Odigeo.UIElements.translations.alertSessionAboutToExpire = {
old: {
headerToShow: "Plus que 10\u00A0minutes",
contentToShow: "Nous ne pouvons maintenir les prix que pour une dur\u00E9e limit\u00E9e. R\u00E9servez avant qu\'il ne soit trop tard !",
seatsToShow: "Plus que $[_pl(%1$s|1 si\u00E8ge|%1$s si\u00E8ges)] !",
seatsLeft: "9"
},
flights: {
header: {
a: "Les bonnes offres ont une fin !",
b: "Vous y \u00EAtes presque ! Juste $[_pl(%1$s|1 \u00E9tape de plus|%1$s \u00E9tapes de plus)]"
},
content: {
a: "Nous ne pouvons malheureusement pas vous garder les billets. R\u00E9servez avant qu\u2019il ne soit trop tard.",
b: "Nous pouvons garder ce tarif pendant 10 minutes."
},
footer: "Offres exclusives par t\u00E9l\u00E9phone&nbsp;:",
close: "OK, MERCI !",
phone: "0892 68 64 60",
phoneHref: "",
hours: "",
charge: "Service 0,80 \u20AC\/min + prix appel"
},
dp: {
header: {
a: "Les bonnes offres ont une fin !",
b: "Vous y \u00EAtes presque ! Juste %1$s \u00E9tapes de plus"
},
content: {
a: "Ces r\u00E9sultats sont disponibles pendant 10 minutes seulement",
b: "Nous pouvons garder cette offre de Vol + H\u00F4tel pendant 10 minutes"
},
footer: "Offres exclusives par t\u00E9l\u00E9phone&nbsp;:",
phone: "0892 68 64 60",
phoneHref: "",
hours: "",
charge: "Service 0,80 \u20AC\/min + prix appel"
}
};
}()); 
(function() {
'use strict';
Odigeo.UIElements.translations.loadingMyTripsDialog = {
content: {
title: "Chargement de Mes voyages...",
text: "Chaque connexion \u00E0 Mes voyages est l\'occasion de d\u00E9couvrir une offre exclusive."
}
}
}()); 
(function() {
'use strict';
Odigeo.UIElements.translations.loadingMyTripsErrorDialog = {
content: {
text: "Veuillez nous excuser, la connexion est indisponible pour le moment. R\u00E9essayez plus tard."
}
}
}()); 
Odigeo.Events.tap = 'click';
    
var r='\n\n\n' +
'       _____                                  ____  _____ _____ _____ ______ ____  \n'+
'      |  __ \\                                / __ \\|  __ \\_   _/ ____|  ____/ __ \\ \n'+
'   ___| |  | |_ __ ___  __ _ _ __ ___  ___  | |  | | |  | || || |  __| |__ | |  | |\n'+
'  / _ \\ |  | | \'__/ _ \\/ _` | \'_ ` _ \\/ __| | |  | | |  | || || | |_ |  __|| |  | |\n'+
' |  __/ |__| | | |  __/ (_| | | | | | \\__ \\ | |__| | |__| || || |__| | |___| |__| |\n'+
'  \\___|_____/|_|  \\___|\\__,_|_| |_| |_|___/  \\____/|_____/_____\\_____|______\\____/ \n\n' +
'Visit http://www.edreamsodigeo.com/careers/ to learn about our current job openings.\n\n';
console&&console.log&&console.log(r);  
}());