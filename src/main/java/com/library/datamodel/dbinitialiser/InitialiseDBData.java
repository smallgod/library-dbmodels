/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.datamodel.dbinitialiser;

import com.library.customexception.MyCustomException;
import com.library.datamodel.Constants.AdScreenType;
import com.library.datamodel.Constants.AdXpoAccountStatus;
import com.library.datamodel.Constants.NamedConstants;
import com.library.datamodel.Constants.ProgDisplayLayout;
import com.library.datamodel.jaxb.config.v1_0.Amounttype;
import com.library.datamodel.model.v1_0.AdAudienceType;
import com.library.datamodel.model.v1_0.AdBusiness;
import com.library.datamodel.model.v1_0.AdBusinessService;
import com.library.datamodel.model.v1_0.AdClient;
import com.library.datamodel.model.v1_0.AdScreen;
import com.library.datamodel.model.v1_0.AdScreenLayout;
import com.library.datamodel.model.v1_0.AdScreenSize;
import com.library.datamodel.model.v1_0.AdTerminal;
import com.library.datamodel.model.v1_0.AdTimeSlot;
import com.library.datamodel.model.v1_0.AdUser;
import com.library.hibernate.CustomHibernate;
import com.library.httpconnmanager.Security;
import com.library.hibernate.utils.HibernateUtils;
import com.library.sglogger.util.LoggerUtil;
import com.library.utilities.NumericIDGenerator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.joda.time.Duration;
import org.joda.time.LocalTime;

/**
 *
 * @author smallgod
 */
public class InitialiseDBData {

    private static final LoggerUtil logger = new LoggerUtil(InitialiseDBData.class);

    //AdAudience types
    private AdAudienceType aud1;
    private AdAudienceType aud2;
    private AdAudienceType aud3;
    private AdAudienceType aud4;
    private AdAudienceType aud5;
    private AdAudienceType aud6;
    private AdAudienceType aud7;
    private AdAudienceType aud8;
    private AdAudienceType aud9;
    private AdAudienceType aud10;
    private AdAudienceType aud11;
    private AdAudienceType aud12;

    //Business types
    private AdBusinessService bus1;
    private AdBusinessService bus2;
    private AdBusinessService bus3;
    private AdBusinessService bus4;
    private AdBusinessService bus5;
    private AdBusinessService bus6;
    private AdBusinessService bus7;
    private AdBusinessService bus8;
    private AdBusinessService bus9;
    private AdBusinessService bus10;
    private AdBusinessService bus11;
    private AdBusinessService bus12;
    private AdBusinessService bus13;
    private AdBusinessService bus14;
    private AdBusinessService bus15;

    private AdUser testUser;
    private AdUser guestUser;
    private AdUser templatesCampaignUser;
    private AdClient testAdClient;
    private AdClient guestAdClient;
    private AdClient templatesCampaignClient;

    private final CustomHibernate customHibernate;

    public InitialiseDBData(CustomHibernate customHibernate) {
        this.customHibernate = customHibernate;
    }

    /**
     *
     * @throws MyCustomException
     */
    public void addAudienceTypes() throws MyCustomException {

        aud1 = new AdAudienceType();
        aud1.setAudienceName("Corporates");

        aud2 = new AdAudienceType();
        aud2.setAudienceName("Expats");

        aud3 = new AdAudienceType();
        aud3.setAudienceName("Families");

        aud4 = new AdAudienceType();
        aud4.setAudienceName("Mainly men");

        aud5 = new AdAudienceType();
        aud5.setAudienceName("Mainly women");

        aud6 = new AdAudienceType();
        aud6.setAudienceName("Students");

        aud7 = new AdAudienceType();
        aud7.setAudienceName("Tourists");

        aud8 = new AdAudienceType();
        aud8.setAudienceName("Traders");

        aud9 = new AdAudienceType();
        aud9.setAudienceName("Upscale");

        aud10 = new AdAudienceType();
        aud10.setAudienceName("Boda-boda cyclists");

        aud11 = new AdAudienceType();
        aud11.setAudienceName("Business people");

        aud12 = new AdAudienceType();
        aud11.setAudienceName("Taxi drivers");

        Set<AdAudienceType> audienceTypes = new HashSet<>();
        audienceTypes.add(aud1);
        audienceTypes.add(aud2);
        audienceTypes.add(aud3);
        audienceTypes.add(aud4);
        audienceTypes.add(aud5);
        audienceTypes.add(aud6);
        audienceTypes.add(aud7);
        audienceTypes.add(aud8);
        audienceTypes.add(aud9);
        audienceTypes.add(aud10);
        audienceTypes.add(aud11);
        audienceTypes.add(aud12);

        customHibernate.saveBulk(audienceTypes);

    }

    /**
     *
     * @throws MyCustomException
     */
    public void addBusinessTypes() throws MyCustomException {
        //BAR | SALON | SPORTS_HOUSE | HOTEL | HOSTELS | SCHOOLS | UNIVERSITIES | AIRPORT | BIBANDA | RESTAURANT | SUPERMARKET | SHOP

        bus1 = new AdBusinessService();
        bus1.setBusinessServiceName("Bar");
        bus1.setBusinessServiceShortName("bar");

        bus2 = new AdBusinessService();
        bus2.setBusinessServiceName("Salon");
        bus2.setBusinessServiceShortName("salon");

        bus3 = new AdBusinessService();
        bus3.setBusinessServiceName("Sports Betting");
        bus3.setBusinessServiceShortName("betting");

        bus4 = new AdBusinessService();
        bus4.setBusinessServiceName("Small Shop");
        bus4.setBusinessServiceShortName("shop");

        bus5 = new AdBusinessService();
        bus5.setBusinessServiceName("Local cinema - Kibanda");
        bus5.setBusinessServiceShortName("kibanda");

        bus6 = new AdBusinessService();
        bus6.setBusinessServiceName("Hotel");
        bus6.setBusinessServiceShortName("hotel");

        bus7 = new AdBusinessService();
        bus7.setBusinessServiceName("Hostel");
        bus7.setBusinessServiceShortName("hostel");

        bus8 = new AdBusinessService();
        bus8.setBusinessServiceName("School");
        bus8.setBusinessServiceShortName("school");

        bus9 = new AdBusinessService();
        bus9.setBusinessServiceName("University");
        bus9.setBusinessServiceShortName("versity");

        bus10 = new AdBusinessService();
        bus10.setBusinessServiceName("Aiport");
        bus10.setBusinessServiceShortName("airport");

        bus11 = new AdBusinessService();
        bus11.setBusinessServiceName("Restaurant");
        bus11.setBusinessServiceShortName("restaurant");

        bus12 = new AdBusinessService();
        bus12.setBusinessServiceName("Super market");
        bus12.setBusinessServiceShortName("supermarket");

        bus13 = new AdBusinessService();
        bus13.setBusinessServiceName("Community audience");
        bus13.setBusinessServiceShortName("community");

        bus14 = new AdBusinessService();
        bus14.setBusinessServiceName("Casino");
        bus14.setBusinessServiceShortName("casino");

        bus15 = new AdBusinessService();
        bus15.setBusinessServiceName("Hospital");
        bus15.setBusinessServiceShortName("hospital");

        Set<AdBusinessService> businessTypes = new HashSet<>();

        businessTypes.add(bus1);
        businessTypes.add(bus2);
        businessTypes.add(bus3);
        businessTypes.add(bus4);
        businessTypes.add(bus5);
        businessTypes.add(bus6);
        businessTypes.add(bus7);
        businessTypes.add(bus8);
        businessTypes.add(bus9);
        businessTypes.add(bus10);
        businessTypes.add(bus11);
        businessTypes.add(bus12);
        businessTypes.add(bus13);
        businessTypes.add(bus14);
        businessTypes.add(bus15);

        customHibernate.saveBulk(businessTypes);

    }

    /**
     * Add a terminal You can later add a screen and link it to this terminal or
     * vice-versa
     *
     * @param taskX
     * @param taskY
     * @param taskZ
     * @param terminalId
     * @param terminalName
     * @param terminalDesc
     * @param latitude
     * @param longitude
     * @return
     * @throws com.library.customexception.MyCustomException
     */
    public AdTerminal addTerminal( //can be done independently of screen addition
            int taskX,
            int taskY,
            int taskZ,
            String terminalId,
            String terminalName,
            String terminalDesc,
            double latitude,
            double longitude
    ) throws MyCustomException {

        //PROD
        //int taskX = 1493101974;
        //int taskY = 1493101989;
        //int taskZ = 1504714261;
        AdTerminal terminal = new AdTerminal();
        terminal.setLatitude(latitude);
        terminal.setLongitude(longitude);
        terminal.setTerminalId(terminalId);
        terminal.setTerminalName(terminalName);
        terminal.setTerminalDescription(terminalDesc);
        terminal.setTaskIdX(taskX);
        terminal.setTaskIdY(taskY);
        terminal.setTaskIdZ(taskZ);

        customHibernate.saveEntity(terminal);

        return terminal;

    }

    /**
     * Create a guest user, who will be used for Guest Logins. This user must me
     * created in order for guest logins to work
     *
     * @throws MyCustomException
     */
    public void addGuestUser() throws MyCustomException {

        String userId = NamedConstants.GUEST_USER_ID;
        String password = NamedConstants.GUEST_USER_PASSWORD;

        guestUser = new AdUser();
        guestUser.setAccountStatus(AdXpoAccountStatus.ACTIVE);
        guestUser.setAgreedToTermsOfuse(Boolean.TRUE);
        guestUser.setFirstName("Guest");
        guestUser.setPrimaryPhone(userId);
        guestUser.setPassword(Security.createHash(password));
        guestUser.setUserId(userId);
        guestUser.setIsPasswordEncrypted(Boolean.TRUE);
        guestUser.setFailedLoginAttempts(0);
        //adUser.setUserId(GeneralUtils.generateUserId(primaryPhone));

        customHibernate.saveEntity(guestUser);
    }

    /**
     * User will be both a testAdClient and a screen owner
     *
     * @throws com.library.customexception.MyCustomException
     */
    public void addTestUser() throws MyCustomException {

        String userId = NamedConstants.TEST_USER_ID;
        String password = NamedConstants.TEST_USER_PASSWORD;

        testUser = new AdUser();
        testUser.setAccountStatus(AdXpoAccountStatus.ACTIVE);
        testUser.setAgreedToTermsOfuse(Boolean.TRUE);
        testUser.setFirstName("Test");
        testUser.setPrimaryPhone(userId);
        testUser.setPassword(Security.createHash(password));
        testUser.setUserId(userId);
        testUser.setIsPasswordEncrypted(Boolean.TRUE);
        guestUser.setFailedLoginAttempts(0);
        //adUser.setUserId(GeneralUtils.generateUserId(primaryPhone));

        customHibernate.saveEntity(testUser);

    }

    /**
     *
     * @return @throws MyCustomException
     */
    private boolean screenLayoutsInitialised() throws MyCustomException {

        int count = customHibernate.countRows(AdScreenLayout.class, null).intValue();

        if (count > 0) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }

    /**
     * User will be both a testAdClient and a screen owner
     *
     * @throws com.library.customexception.MyCustomException
     */
    public void addTemplateCampaignsUser() throws MyCustomException {

        String userId = NamedConstants.TEMPLATE_CAMPAIGNS_USER_ID;
        String password = NamedConstants.TEMPLATE_CAMPAIGNS_USER_PASSWORD;

        templatesCampaignUser = new AdUser();
        templatesCampaignUser.setAccountStatus(AdXpoAccountStatus.ACTIVE);
        templatesCampaignUser.setAgreedToTermsOfuse(Boolean.TRUE);
        templatesCampaignUser.setFirstName("Templates User");
        templatesCampaignUser.setPrimaryPhone(userId);
        templatesCampaignUser.setPassword(Security.createHash(password));
        templatesCampaignUser.setUserId(userId);
        templatesCampaignUser.setIsPasswordEncrypted(Boolean.TRUE);
        guestUser.setFailedLoginAttempts(0);
        //adUser.setUserId(GeneralUtils.generateUserId(primaryPhone));

        customHibernate.saveEntity(templatesCampaignUser);

    }

    /**
     * Update user password
     *
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @throws MyCustomException
     */
    public void updateUserPassword(String userId, String oldPassword, String newPassword) throws MyCustomException {

        Map<String, Set<Object>> fetchProps = new HashMap<>();
        //fetchProps.put("password", new HashSet<>(Arrays.asList((Object) oldPassword)));
        fetchProps.put("userId", new HashSet<>(Arrays.asList((Object) userId)));

        AdUser user = customHibernate.fetchEntity(AdUser.class, fetchProps);

        //validate old password first
        String hashedPasswordFromDB = user.getPassword();
        Security.validatePassword(oldPassword, hashedPasswordFromDB);

        user.setPassword(Security.createHash(newPassword));
        customHibernate.updateEntity(user);

    }

    /**
     * Update user password
     *
     * @param oldUserId
     * @param newUserId
     * @param password
     * @throws MyCustomException
     */ //has issues - error -> Cannot delete or update a parent row: a foreign key constraint fails 
    //(`adexpo_main`.`ad_client`, CONSTRAINT `FK_d6m1lbjx8rop1yg0xiukmbhro` FOREIGN KEY (`user_id`) REFERENCES `ad_user` (`user_id`))
    public void updateUserId(String oldUserId, String newUserId, String password) throws MyCustomException {

        Map<String, Set<Object>> fetchProps = new HashMap<>();
        //fetchProps.put("password", new HashSet<>(Arrays.asList((Object) password)));
        fetchProps.put("userId", new HashSet<>(Arrays.asList((Object) oldUserId)));

        AdUser user = customHibernate.fetchEntity(AdUser.class, fetchProps);

        //validate old password first
        String hashedPasswordFromDB = user.getPassword();
        Security.validatePassword(password, hashedPasswordFromDB);

        user.setUserId(newUserId);
        customHibernate.updateEntity(user);

    }

    /**
     *
     * @throws MyCustomException
     */
    public void addTestCampaignClient() throws MyCustomException {

        testAdClient = new AdClient();
        testAdClient.setAdUser(this.testUser);
        testAdClient.setIsToBeCensored(Boolean.TRUE);
        testAdClient.setNumberOfPrograms(0);

        customHibernate.saveEntity(testAdClient);
    }

    /**
     *
     * @throws MyCustomException
     */
    public void addGuestCampaignClient() throws MyCustomException {

        guestAdClient = new AdClient();
        guestAdClient.setAdUser(this.guestUser);
        guestAdClient.setIsToBeCensored(Boolean.TRUE);
        guestAdClient.setNumberOfPrograms(0);

        customHibernate.saveEntity(guestAdClient);
    }

    /**
     *
     * @throws MyCustomException
     */
    public void addTemplateCampaignClient() throws MyCustomException {

        templatesCampaignClient = new AdClient();
        templatesCampaignClient.setAdUser(this.templatesCampaignUser);
        templatesCampaignClient.setIsToBeCensored(Boolean.TRUE);
        templatesCampaignClient.setNumberOfPrograms(0);

        customHibernate.saveEntity(templatesCampaignClient);
    }

    /**
     * Add screen sizes
     *
     * @throws MyCustomException
     */
    public void addScreenSizes() throws MyCustomException {

        Set<AdScreenSize> screensizes = new HashSet<>();

        AdScreenSize fifteen = new AdScreenSize();
        fifteen.setScreenSizeCode("FIFTEEN");
        fifteen.setScreenSizeName("15 INCH");
        fifteen.setScreenSizeValue(1.000f);

        AdScreenSize nineteen = new AdScreenSize();
        nineteen.setScreenSizeCode("NINETEEN");
        nineteen.setScreenSizeName("19 INCH");
        nineteen.setScreenSizeValue(1.050f);

        AdScreenSize twentyOne = new AdScreenSize();
        twentyOne.setScreenSizeCode("TWENTYONE");
        twentyOne.setScreenSizeName("21 INCH");
        twentyOne.setScreenSizeValue(1.075f);

        AdScreenSize twentyNine = new AdScreenSize();
        twentyNine.setScreenSizeCode("TWENTYNINE");
        twentyNine.setScreenSizeName("29 INCH");
        twentyNine.setScreenSizeValue(1.100f);

        AdScreenSize thirtyTwo = new AdScreenSize();
        thirtyTwo.setScreenSizeCode("THIRTYTWO");
        thirtyTwo.setScreenSizeName("32 INCH");
        thirtyTwo.setScreenSizeValue(1.150f);

        AdScreenSize fourty = new AdScreenSize();
        fourty.setScreenSizeCode("FOURTY");
        fourty.setScreenSizeName("40 INCH");
        fourty.setScreenSizeValue(1.175f);

        AdScreenSize fiftyTwo = new AdScreenSize();
        fiftyTwo.setScreenSizeCode("FIFTYTWO");
        fiftyTwo.setScreenSizeName("52 INCH");
        fiftyTwo.setScreenSizeValue(1.200f);

        screensizes.add(fifteen);
        screensizes.add(nineteen);
        screensizes.add(twentyOne);
        screensizes.add(twentyNine);
        screensizes.add(thirtyTwo);
        screensizes.add(fourty);
        screensizes.add(fiftyTwo);

        customHibernate.saveBulk(screensizes);
    }

    /**
     * Add available screen layouts to the system
     *
     * @throws MyCustomException
     */
    public void addDisplayLayouts() throws MyCustomException {

        Set<AdScreenLayout> screenLayouts = new HashSet<>();

        //FULLSCREEN
        AdScreenLayout fullScreenLayout = new AdScreenLayout();
        fullScreenLayout.setLayoutId(ProgDisplayLayout.FULL_SCREEN.getValue());
        fullScreenLayout.setLayoutName("Full-Screen only layout");
        fullScreenLayout.setLayoutValue(1.500f);

        //FULLSCREEN-TEXT
        AdScreenLayout fullScreenTextLayout = new AdScreenLayout();
        fullScreenTextLayout.setLayoutId(ProgDisplayLayout.FULLSCREEN_TEXT.getValue());
        fullScreenTextLayout.setLayoutName("Full-Screen and Text layout");
        fullScreenTextLayout.setLayoutValue(1.750f);

        //3SPLIT
        AdScreenLayout threeScreenSplit = new AdScreenLayout();
        threeScreenSplit.setLayoutId(ProgDisplayLayout.THREE_SPLIT.getValue());
        threeScreenSplit.setLayoutName("3-Screen split layout");
        threeScreenSplit.setLayoutValue(1.300f);

        //2SPLIT
        AdScreenLayout twoScreenSplit = new AdScreenLayout();
        twoScreenSplit.setLayoutId(ProgDisplayLayout.TWO_SPLIT.getValue());
        twoScreenSplit.setLayoutName("2-Screen split layout");
        twoScreenSplit.setLayoutValue(1.200f);

        //TEXT
        AdScreenLayout textOnlyLayout = new AdScreenLayout();
        textOnlyLayout.setLayoutId(ProgDisplayLayout.TEXT_ONLY.getValue());
        textOnlyLayout.setLayoutName("Text-Only layout");
        textOnlyLayout.setLayoutValue(1.000f);

        //UNKNOWN
        AdScreenLayout unKnownLayout = new AdScreenLayout();
        unKnownLayout.setLayoutId(ProgDisplayLayout.UNKNOWN.getValue());
        unKnownLayout.setLayoutName("Unknown layout");
        unKnownLayout.setLayoutValue(1.000f);
        unKnownLayout.setDescription("This will be the default layout used especially if there is no layout chosen. It can be anything");

        screenLayouts.add(twoScreenSplit);
        screenLayouts.add(threeScreenSplit);
        screenLayouts.add(fullScreenLayout);
        screenLayouts.add(textOnlyLayout);
        screenLayouts.add(fullScreenTextLayout);
        screenLayouts.add(unKnownLayout);

        customHibernate.saveBulk(screenLayouts);

    }

    /**
     * The available time slots for campaigns e.g. PRIME (prime time)
     *
     * @throws MyCustomException
     */
    public void addTimeSlots() throws MyCustomException {

        /*
            INSTANT (now @5000/-) | LATENIGHT (12am - 3.59am @500/-) | FREEBIE (4am - 5.59am @0/-)| EARLY (6am-11.59am @700/-) | LUNCH (12pm-4.59pm @1,000/-) | RUSHHOUR (5pm-7.59pm @1200/-) | PRIME (8pm-10.59pm @1500/-)  
         */
        Set<AdTimeSlot> timeSlots = new HashSet<>();

        Amounttype slotAdPrice = new Amounttype();
        slotAdPrice.setCurrencycode("UGX");
        slotAdPrice.setAmount(700);

        //INSTANT - SLOT
        slotAdPrice = new Amounttype();
        slotAdPrice.setCurrencycode("UGX");
        slotAdPrice.setAmount(3000);
        AdTimeSlot timeSlot = new AdTimeSlot();
        timeSlot.setStartTime(new LocalTime(0, 0));
        timeSlot.setEndTime(new LocalTime(0, 0));
        timeSlot.setSlotAdPrice(slotAdPrice);
        timeSlot.setTimeSlotCode("INSTANT");
        timeSlot.setTimeSlotName("Instant Ad");
        timeSlot.setTimeSlotDescription("Dont wait in a queue, play your advert now!");
        timeSlot.setIsInstant(Boolean.TRUE);
        timeSlot.setSlotDiscount(0.0f);
        timeSlot.setApprovalDelay(Duration.standardMinutes(10).getMillis());
        timeSlots.add(timeSlot);

        //LATENIGHT - SLOT
        slotAdPrice = new Amounttype();
        slotAdPrice.setCurrencycode("UGX");
        slotAdPrice.setAmount(500);
        timeSlot = new AdTimeSlot();
        timeSlot.setStartTime(new LocalTime(23, 0));
        timeSlot.setEndTime(new LocalTime(3, 59));
        timeSlot.setSlotAdPrice(slotAdPrice);
        timeSlot.setTimeSlotCode("LATENITE");
        timeSlot.setTimeSlotName("Late Night");
        timeSlot.setTimeSlotDescription("Late in the wee hours of the night, for clubbers and other 'nocturnals' ");
        timeSlot.setIsInstant(Boolean.FALSE);
        timeSlot.setSlotDiscount(0.0f);
        timeSlot.setApprovalDelay(Duration.standardMinutes(15).getMillis());
        timeSlots.add(timeSlot);

        //FREEBIE - SLOT
        slotAdPrice = new Amounttype();
        slotAdPrice.setCurrencycode("UGX");
        slotAdPrice.setAmount(0);
        timeSlot = new AdTimeSlot();
        timeSlot.setStartTime(new LocalTime(4, 0));
        timeSlot.setEndTime(new LocalTime(5, 59));
        timeSlot.setSlotAdPrice(slotAdPrice);
        timeSlot.setTimeSlotCode("FREEBIE");
        timeSlot.setTimeSlotName("Free Ads");
        timeSlot.setTimeSlotDescription("2 hours of free advertising");
        timeSlot.setIsInstant(Boolean.FALSE);
        timeSlot.setSlotDiscount(100.0f);
        timeSlot.setApprovalDelay(Duration.standardMinutes(15).getMillis());
        timeSlots.add(timeSlot);

        //EARLY - SLOT
        slotAdPrice = new Amounttype();
        slotAdPrice.setCurrencycode("UGX");
        slotAdPrice.setAmount(700);
        timeSlot = new AdTimeSlot();
        timeSlot.setStartTime(new LocalTime(6, 0));
        timeSlot.setEndTime(new LocalTime(11, 59));
        timeSlot.setSlotAdPrice(slotAdPrice);
        timeSlot.setTimeSlotCode("EARLYBIRD");
        timeSlot.setTimeSlotName("Early Bird");
        timeSlot.setTimeSlotDescription("Time of the Day early in the morning, when potential clients are/have waking up/woken up");
        timeSlot.setIsInstant(Boolean.FALSE);
        timeSlot.setSlotDiscount(0.0f);
        timeSlot.setApprovalDelay(Duration.standardMinutes(15).getMillis());
        timeSlots.add(timeSlot);

        //LUNCHHOUR - SLOT
        slotAdPrice = new Amounttype();
        slotAdPrice.setCurrencycode("UGX");
        slotAdPrice.setAmount(1000);
        timeSlot = new AdTimeSlot();
        timeSlot.setStartTime(new LocalTime(12, 0));
        timeSlot.setEndTime(new LocalTime(16, 59));
        timeSlot.setSlotAdPrice(slotAdPrice);
        timeSlot.setTimeSlotCode("LUNCHHOUR");
        timeSlot.setTimeSlotName("Lunch Hour");
        timeSlot.setTimeSlotDescription("Lunch hour");
        timeSlot.setIsInstant(Boolean.FALSE);
        timeSlot.setSlotDiscount(0.0f);
        timeSlot.setApprovalDelay(Duration.standardMinutes(15).getMillis());
        timeSlots.add(timeSlot);

        //RUSHHOUR - SLOT
        slotAdPrice = new Amounttype();
        slotAdPrice.setCurrencycode("UGX");
        slotAdPrice.setAmount(1200);
        timeSlot = new AdTimeSlot();
        timeSlot.setStartTime(new LocalTime(17, 0));
        timeSlot.setEndTime(new LocalTime(19, 59));
        timeSlot.setSlotAdPrice(slotAdPrice);
        timeSlot.setTimeSlotCode("RUSHHOUR");
        timeSlot.setTimeSlotName("Rush Hour");
        timeSlot.setTimeSlotDescription("Time of the Day in the evening when potential clients are/have leaving/left their work places");
        timeSlot.setIsInstant(Boolean.FALSE);
        timeSlot.setSlotDiscount(0.0f);
        timeSlot.setApprovalDelay(Duration.standardMinutes(15).getMillis());
        timeSlots.add(timeSlot);

        //PRIME - SLOT
        slotAdPrice = new Amounttype();
        slotAdPrice.setCurrencycode("UGX");
        slotAdPrice.setAmount(1500);
        timeSlot = new AdTimeSlot();
        timeSlot.setStartTime(new LocalTime(20, 0));
        timeSlot.setEndTime(new LocalTime(22, 59));
        timeSlot.setSlotAdPrice(slotAdPrice);
        timeSlot.setTimeSlotCode("PRIME");
        timeSlot.setTimeSlotName("Prime Time");
        timeSlot.setTimeSlotDescription("Most potential clients get to be glued on their TVs at this time. An opporune moment to advertise");
        timeSlot.setIsInstant(Boolean.FALSE);
        timeSlot.setSlotDiscount(0.0f);
        timeSlot.setApprovalDelay(Duration.standardMinutes(15).getMillis());
        timeSlots.add(timeSlot);

        customHibernate.saveBulk(timeSlots);

    }

    /**
     * Generate Screen Id
     *
     * @param businessId
     * @return
     * @throws MyCustomException
     */
    public String generateScreenId(String businessId) throws MyCustomException {

        //get the most recent Screen under this business
        AdScreen recentScreen = customHibernate.getMostRecentRecord(AdScreen.class, "id", "adBusiness.businessId", businessId);
        String incremStart;

        if (recentScreen == null) {
            logger.debug("recentScreen is null");

            incremStart = NamedConstants.SCREEN_START_ID;
        } else {
            String idToIncrement = recentScreen.getScreenId();
            int len = idToIncrement.length();
            idToIncrement = idToIncrement.substring(len - 2); //e.g. if screenId is SASS01, substring will give us -> '01'

            //generatorId = AlphaNumericIDGenerator.generateNextId(idToIncrement);
            incremStart = NumericIDGenerator.generateNextId(idToIncrement);
        }

        String screenId = businessId + "-" + incremStart;

        return screenId;

    }

    public void gummaaza() throws MyCustomException {
        return;
    }

    /**
     * Initialise Database
     *
     * @throws MyCustomException
     */
    public void initDB() throws MyCustomException {

        if (screenLayoutsInitialised()) {
            logger.debug("Database already initialised, skipping!");
            return;
        }

        //screen layouts
        addDisplayLayouts();

        //screen sizes
        addScreenSizes();

        //time slots
        addTimeSlots();

        //audience types
        addAudienceTypes();

        //business types
        addBusinessTypes();

        //Guest user
        addGuestUser();

        //test user
        addTestUser();

        //Templates campaign user
        addTemplateCampaignsUser();

        // test advert client
        addTestCampaignClient();

        // test advert client
        addGuestCampaignClient();

        //Templates campaign client
        addTemplateCampaignClient();

        //add terminal -terminalId is got from DSM server database after syncing terminal to server
        //AdTerminal terminal = addTerminal(1506182937, 1506182957, 1504710509, "230901364440706", "FORTEBET Terminal-1", "First pilot terminal - Original terminal - ForteBet", 13.0412658, 80.2338514); //Chenai - India -> 600017
    }
}
