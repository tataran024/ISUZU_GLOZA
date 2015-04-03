package com.isz.npl.gui.ecs.msjcf31;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.classtechnology.base.common.accessLog.BaseAccessLogger;
import com.classtechnology.base.common.accessLog.BaseAccessLogger.AccessType;
import com.classtechnology.base.common.constant.BaseWindowOpenMode;
import com.classtechnology.base.common.custom.db.BaseDbConnect;
import com.classtechnology.base.common.custom.db.BaseDbGroupableTable;
import com.classtechnology.base.common.custom.db.accesser.BaseResultSetTableModel;
import com.classtechnology.base.common.custom.function.BaseFunctionRef;
import com.classtechnology.base.common.custom.function.BaseUserFunction;
import com.classtechnology.base.common.custom.gui.BaseAlphaNumericTextField;
import com.classtechnology.base.common.custom.gui.BaseButton;
import com.classtechnology.base.common.custom.gui.BaseLabel;
import com.classtechnology.base.common.custom.gui.BaseTextField;
import com.classtechnology.base.common.custom.gui.autoFilter.BaseAutoFilterTableModel;
import com.classtechnology.base.common.custom.gui.container.BaseDefaultFrame;
import com.classtechnology.base.common.custom.gui.container.BasePanel;
import com.classtechnology.base.common.custom.gui.container.BaseScrollPane;
import com.classtechnology.base.common.custom.gui.container.BaseWindowCloseButton;
import com.classtechnology.base.common.custom.gui.table.BaseAlphaNumericTextFieldCellComponent;
import com.classtechnology.base.common.custom.gui.table.BaseCheckBoxCellComponent;
import com.classtechnology.base.common.custom.gui.table.BaseTableModelCellStatusControl;
import com.classtechnology.base.common.custom.validator.BaseValidatorConstant;
import com.classtechnology.base.common.framework.exception.BaseServiceReturnContainerException;
import com.classtechnology.base.common.util.BaseLog;
import com.classtechnology.base.common.util.BaseMessageIndicator;
import com.classtechnology.base.common.util.BaseStringUtil;
import com.classtechnology.custom.common.CtCustomConstants;
import com.classtechnology.custom.common.CtCustomUtil;
import com.classtechnology.custom.db.CtDynamicConditionManager;
import com.classtechnology.custom.function.CtActionEvent;
import com.classtechnology.custom.function.CtActionListener;
import com.classtechnology.custom.function.CtFunction;
import com.classtechnology.custom.function.CtFunctionAdapter;
import com.classtechnology.custom.function.CtFunctionSuccessEvent;
import com.classtechnology.custom.relation.CtNamedComponentRelation;
import com.classtechnology.framework.CtAppContainer;
import com.classtechnology.framework.CtAppRow;
import com.classtechnology.framework.CtAppRowSet;
import com.classtechnology.framework.service.CtAppLogicException;
import com.isz.npl.common.ISZFunctionUtil;
import com.isz.npl.gui.common.ISZAppRCAServiceInvoker;
import com.isz.npl.gui.common.ISZGlobalInfo;
import com.isz.npl.gui.common.ISZGuiCommonLibMsjlibx;
import com.isz.npl.gui.common.ISZOutParameterInfo;
import com.isz.npl.gui.common.ISZGuiCommonLibMsjlibx.FpMsjdef;
import com.isz.npl.gui.common.ISZGuiCommonLibMsjlibx.FpMsjvar;
/**
 *
 */
public class FrmMSJCF31 extends BaseDefaultFrame {

	private static final long serialVersionUID = 1L;
	private static final String PGM_ID = "MSJCF31";

	private BasePanel pnlMain = null;
	private BasePanel pnlNorth	= null;
	private BasePanel pnlCenter = null;  //  @jve:decl-index=0:visual-constraint="668,1032"
	private BasePanel pnlCenterCenter = null;
	private BasePanel pnlCenterCenter2 = null;  //  @jve:decl-index=0:visual-constraint="10,1479"
	private BasePanel pnlLine = null;
	private BasePanel pnlSouth	= null;
	private BasePanel pnlRect	= null;
	private BaseDbConnect dbcon = null;  //  @jve:decl-index=0:visual-constraint="13,624"
	private BaseAlphaNumericTextField txtBlkKey1EcrNo = null;
	private BaseAlphaNumericTextField txtBlkKey1RevEcr = null;
	private BaseAlphaNumericTextField txtBlkKey1Year = null;
	private BaseAlphaNumericTextField txtBlkKey1Book = null;

	private BaseAlphaNumericTextField txtBlkKey2EcrNo = null;
	private BaseAlphaNumericTextField txtBlkKey2RevEcr = null;
	private BaseAlphaNumericTextField txtBlkKey2Year = null;
	private BaseAlphaNumericTextField txtBlkKey2Book = null;

	private BaseTextField txtBlkCtrlInsCnt = null;  //  @jve:decl-index=0:visual-constraint="10,699"
	private BaseTextField txtBlkCtrlUpdCnt = null;  //  @jve:decl-index=0:visual-constraint="45,700"
	private BaseTextField txtBlkCtrlBpUpdFlg = null;  //  @jve:decl-index=0:visual-constraint="85,700"
	private BaseTextField txtBlkCtrlEcsEffDate = null;  //  @jve:decl-index=0:visual-constraint="127,700"
	private BaseTextField txtBlkCtrlBpStartDate = null;  //  @jve:decl-index=0:visual-constraint="174,700"
	private BaseTextField txtBlkCtrlBpStartEcrNo = null;  //  @jve:decl-index=0:visual-constraint="217,701"
	private BaseTextField txtBlkCtrlBpStartRevEcr = null;  //  @jve:decl-index=0:visual-constraint="249,702"
	private BaseTextField txtBlkCtrlBpStopDate = null;  //  @jve:decl-index=0:visual-constraint="288,702"
	private BaseTextField txtBlkCtrlBpStopEcrNo = null;  //  @jve:decl-index=0:visual-constraint="323,702"
	private BaseTextField txtBlkCtrlBpStopRevEcr = null;  //  @jve:decl-index=0:visual-constraint="365,702"

	private BaseDbGroupableTable tblMstbecsu = null;
	private BaseScrollPane scpMstbecsu = null;
	private BaseAlphaNumericTextFieldCellComponent ccpMstbecsuPartNo = null;  //  @jve:decl-index=0:visual-constraint="53,629"
	private BaseAlphaNumericTextFieldCellComponent ccpMstbecsuUpc = null;  //  @jve:decl-index=0:visual-constraint="153,629"
	private BaseAlphaNumericTextFieldCellComponent ccpMstbecsuFna = null;  //  @jve:decl-index=0:visual-constraint="225,629"
	private BaseAlphaNumericTextFieldCellComponent ccpMstbecsuUsageCode = null;  //  @jve:decl-index=0:visual-constraint="279,629"
	private BaseAlphaNumericTextFieldCellComponent ccpMstbecsuUnitQty = null;  //  @jve:decl-index=0:visual-constraint="336,629"
	private BaseAlphaNumericTextFieldCellComponent ccpMstbecsuStartStop = null;  //  @jve:decl-index=0:visual-constraint="398,630"

	private BaseDbGroupableTable tblMstbdtle = null;
	private BaseScrollPane scpMstbdtle = null;

	private BaseLabel lblNowDate = null;  //  @jve:decl-index=0:visual-constraint="620,181"
	private BaseLabel lblVer = null;

	private BaseButton btnDelete = null;
	private BaseButton btnButInsert = null;
	private BaseButton btnSearch = null;
	private BaseButton btnButRegist = null;
	private BaseWindowCloseButton btnButExit = null;

	private CtDynamicConditionManager dcmBlkEcsu1Key1 = null;  //  @jve:decl-index=0:visual-constraint="15,755"
	private CtDynamicConditionManager dcmBlkEcsu1Key2 = null;  //  @jve:decl-index=0:visual-constraint="11,809"
	private CtNamedComponentRelation relCndEcsu1BlkKey1EcrNo = null;  //  @jve:decl-index=0:visual-constraint="119,756"
	private CtNamedComponentRelation relCndEcsu1BlkKey1Year = null;  //  @jve:decl-index=0:visual-constraint="434,751"
	private CtNamedComponentRelation relCndEcsu1BlkKey1Book = null;  //  @jve:decl-index=0:visual-constraint="577,750"
	private CtNamedComponentRelation relCndEcsu1BlkKey1RevEcr = null;  //  @jve:decl-index=0:visual-constraint="273,754"
	private CtDynamicConditionManager dcmBlkDtle1Key1 = null;  //  @jve:decl-index=0:visual-constraint="16,857"
	private CtDynamicConditionManager dcmBlkDtle1Key2 = null;  //  @jve:decl-index=0:visual-constraint="16,906"
	private CtNamedComponentRelation relCndDtle1BlkKey1EcrNo = null;  //  @jve:decl-index=0:visual-constraint="118,855"
	private CtNamedComponentRelation relCndDtle1BlkKey1Year = null;  //  @jve:decl-index=0:visual-constraint="435,852"
	private CtNamedComponentRelation relCndDtle1BlkKey1Book = null;  //  @jve:decl-index=0:visual-constraint="584,851"
	private CtNamedComponentRelation relCndDtle1BlkKey1RevEcr = null;  //  @jve:decl-index=0:visual-constraint="273,855"
	private BaseUserFunction funcQuery = null;  //  @jve:decl-index=0:visual-constraint="3,661"
	private BaseUserFunction funcClear = null;  //  @jve:decl-index=0:visual-constraint="60,661"
	private BaseUserFunction funcPrint = null;  //  @jve:decl-index=0:visual-constraint="122,661"
	private BaseUserFunction funcSave = null;  //  @jve:decl-index=0:visual-constraint="177,661"
	private BaseUserFunction funcCancel = null;  //  @jve:decl-index=0:visual-constraint="234,661"
	private BaseUserFunction funcDelete = null;  //  @jve:decl-index=0:visual-constraint="304,661"
	private BaseUserFunction funcInsert = null;  //  @jve:decl-index=0:visual-constraint="373,661"
	private BaseUserFunction funcExit = null;  //  @jve:decl-index=0:visual-constraint="434,661"
	private BaseUserFunction funcHelp = null;  //  @jve:decl-index=0:visual-constraint="486,661"

	private String parParmIemtdata = "0";
	private String parParmIsztdata = "0";
	private String parParmIemt;
	private String parParmIemtplant;
	private String parParmIemtuser;  //  @jve:decl-index=0:
	private String parParmUserId;  //  @jve:decl-index=0:
	private String parParmUserClass;
	private String parParmCntryGrp;
	private String parParmPlantCode;
	private String parProcessMode = "NOOP";  //  @jve:decl-index=0:
	private String parDataMode = "NODATA";  //  @jve:decl-index=0:
	private String parKey1EcrNo;
	private String parKey1RevEcr;
	private String parKey1Year;
	private String parKey1Book;
	private String parKey2EcrNo;
	private String parKey2RevEcr;
	private String parKey2Year;
	private String parKey2Book;
	private BaseFunctionRef funcInsertEcsu = null;  //  @jve:decl-index=0:visual-constraint="20,948"
	private BaseFunctionRef funcInsertDtle = null;  //  @jve:decl-index=0:visual-constraint="112,949"
	private BaseCheckBoxCellComponent ccpMstbecsuIntent = null;  //  @jve:decl-index=0:visual-constraint="426,628"
	private BaseCheckBoxCellComponent ccpMstbdtleIntent = null;  //  @jve:decl-index=0:visual-constraint="469,629"
	private CtNamedComponentRelation relCndEcsu1BlkKey2EcrNo = null;  //  @jve:decl-index=0:visual-constraint="121,807"
	private CtNamedComponentRelation relCndEcsu1BlkKey2Year = null;  //  @jve:decl-index=0:visual-constraint="274,809"
	private CtNamedComponentRelation relCndEcsu1BlkKey2Book = null;  //  @jve:decl-index=0:visual-constraint="428,808"
	private CtNamedComponentRelation relCndDtle1BlkKey2EcrNo = null;  //  @jve:decl-index=0:visual-constraint="123,909"
	private CtNamedComponentRelation relCndDtle1BlkKey2Year = null;  //  @jve:decl-index=0:visual-constraint="269,908"
	private CtNamedComponentRelation relCndDtle1BlkKey2Book = null;  //  @jve:decl-index=0:visual-constraint="431,908"
	private BaseFunctionRef funcDeleteEcsu = null;  //  @jve:decl-index=0:visual-constraint="21,987"
	private BaseFunctionRef funcSearchDtle = null;  //  @jve:decl-index=0:visual-constraint="111,987"
	private BaseFunctionRef funcSearchEcsu = null;  //  @jve:decl-index=0:visual-constraint="22,1029"

	// CURRENT_ITEM
	private Object beforeItem;
	private Object currentItem;
	
	private boolean delRowFlg = true;
	private boolean dataCancel = false;
	private BaseLabel lblEpl = null;
	private BaseLabel lblAblUpl = null;
	/**
	 * This is the default constructor
	 */
	public FrmMSJCF31() {
		super();
		initialize();
		initCustomComponents();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(892, 672);
		this.setContentPane(getPnlMain());
		this.setLocalizedTitleKey(PGM_ID);
	}
	
	/* (non-Javadoc)
	 * @see com.classtechnology.base.common.custom.gui.container.BaseFrame#windowOpened()
	 */
	@Override
	protected void windowOpened() {
		super.windowOpened();
		this.getParm();
		this.setTrigger();
		this.procMsjcf31WhenNewFormInstance();
		this.setEnableMenuSearchLimitSetting(false);
	}

	/**
	 * パラメータを取得
	 */
	private void getParm() {
		// 呼出元からパラメータを取得する
		parParmUserId = getUserInfo().getUserCode();
		parParmCntryGrp = getUserInfo().getCountryGroup();
		parParmPlantCode = getUserInfo().getPlantCode();
	}
	
	/**
	 * トリガーの設定
	 */
	private void setTrigger() {
		
		// カレントのアイテム退避
		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
			
			@Override
			public void eventDispatched(AWTEvent event) {
				if (event.getID() == FocusEvent.FOCUS_GAINED) {
					if (FrmMSJCF31.this.isFocused()) {
						beforeItem = currentItem;
						currentItem = event.getSource();
					}
				}
			}
		}, AWTEvent.FOCUS_EVENT_MASK);
	}

	/**
	 * This method initialize custom components 
	 */
	private void initCustomComponents(){
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getPnlLine(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getPnlCenterCenter(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getPnlCenterCenter2(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getPnlMain(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getbtnButRegist(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getbtnButSearch(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkKey1RevEcr(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkKey2RevEcr(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkKey1EcrNo(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkKey2EcrNo(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkKey2Year(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkKey1Book(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkKey2Book(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkKey1Year(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getScpMstbdtle(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getScpMstbecsu(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getFuncSearchEcsu(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getFuncSearchDtle(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getFuncDeleteEcsu(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getRelCndDtle1BlkKey2Book(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getRelCndDtle1BlkKey2Year(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getRelCndDtle1BlkKey2EcrNo(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getRelCndEcsu1BlkKey2Book(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getRelCndEcsu1BlkKey2Year(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getRelCndEcsu1BlkKey2EcrNo(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getCcpMstbdtleIntent(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getFuncInsertDtle(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getFuncInsertEcsu(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getCcpMstbecsuIntent(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkCtrlBpStopRevEcr(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkCtrlBpStopEcrNo(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkCtrlBpStopDate(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkCtrlBpStartRevEcr(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkCtrlBpStartEcrNo(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkCtrlBpStartDate(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkCtrlInsCnt(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkCtrlUpdCnt(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkCtrlBpUpdFlg(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTxtBlkCtrlEcsEffDate(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getDbcon(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTblMstbecsu(), this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getTblMstbdtle(), this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getCcpMstbecsuPartNo(), this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getCcpMstbecsuUpc(), this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getCcpMstbecsuFna(), this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getCcpMstbecsuUsageCode(), this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getCcpMstbecsuUnitQty(), this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getCcpMstbecsuStartStop(), this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getRelCndEcsu1BlkKey1EcrNo(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getRelCndEcsu1BlkKey1Year(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getRelCndEcsu1BlkKey1Book(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getRelCndEcsu1BlkKey1RevEcr(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getDcmBlkDtle1Key2(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getDcmBlkDtle1Key1(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getDcmBlkEcsu1Key1(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getDcmBlkEcsu1Key2(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getRelCndDtle1BlkKey1EcrNo(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getRelCndDtle1BlkKey1Year(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getRelCndDtle1BlkKey1Book(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getRelCndDtle1BlkKey1RevEcr(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getFuncQuery(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getFuncClear(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getFuncPrint(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getFuncSave(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getFuncCancel(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getFuncDelete(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getFuncInsert(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getFuncExit(),this);
		com.classtechnology.custom.common.CtCustomUtil.bindToOwner(getFuncHelp(),this);

	}
	
	/** 
	 * This method initializes pnlMain
	 *
	 * @return com.classtechnology.base.common.custom.gui.container.BasePanel
	 */

	private BasePanel getPnlMain() {
		if (pnlMain == null) {
			pnlMain = new BasePanel();
			pnlMain.setLayout(new BorderLayout());
			pnlMain.add(getPnlCenter(),BorderLayout.CENTER);
			pnlMain.add(getPnlNorth(), BorderLayout.NORTH);
			pnlMain.add(getPnlSouth(), BorderLayout.SOUTH);
		}
		return pnlMain;
	}
	
	private BasePanel getPnlLine() {
		if (pnlLine == null) {
			pnlLine = new BasePanel();
			pnlLine.setBounds(new Rectangle(2, 220, 785,1 ));
			pnlLine.setBackground(Color.BLACK);
			pnlLine.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.LOWERED));
		}
		return pnlLine;
	}
	
	private BasePanel getPnlNorth() {
		if (pnlNorth == null) {
			pnlNorth = new BasePanel();
			pnlNorth.setPreferredSize(new Dimension(800, 55));
			pnlNorth.setLayout(null);
			pnlNorth.add(getLblVer(), null);
			pnlNorth.add(getLblNowDate(), null);
			pnlNorth.add(getPnlRect(), null);
		}
		return pnlNorth;
	}

	private BasePanel getPnlCenter() {
		if (pnlCenter == null) {
			pnlCenter = new BasePanel();
			pnlCenter.setLayout(null);
			pnlCenter.setFitToViewportViewWidth(false);
			pnlCenter.add(getPnlCenterCenter(), null);
			pnlCenter.add(getPnlCenterCenter2(), null);
		}
		return pnlCenter;
	}

	private BasePanel getPnlCenterCenter() {
		if (pnlCenterCenter == null) {
			lblEpl = new BaseLabel();
			lblEpl.setBounds(new Rectangle(9, 10, 287, 16));
			lblEpl.setLocalizedLabelKey("EPL_POINTER");
			lblEpl.setToolTipText("");
			pnlCenterCenter = new BasePanel();
			pnlCenterCenter.setLayout(null);
			pnlCenterCenter.setBounds(new Rectangle(0, 4, 880, 271));
			pnlCenterCenter.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
			pnlCenterCenter.setLayout(null);
			pnlCenterCenter.add(getScpMstbecsu(), null);
			pnlCenterCenter.add(getbtnButInsert(), null);
			pnlCenterCenter.add(getbtnButDelete(), null);
			pnlCenterCenter.add(lblEpl, null);
		}
		return pnlCenterCenter;
		
	}
	
	private BasePanel getPnlCenterCenter2() {
		if (pnlCenterCenter2 == null) {
			lblAblUpl = new BaseLabel();
			lblAblUpl.setBounds(new Rectangle(9, 10, 190, 16));
			lblAblUpl.setLocalizedLabelKey("DETAIL_POINTER");
			lblAblUpl.setToolTipText("");
			pnlCenterCenter2 = new BasePanel();
			pnlCenterCenter2.setLayout(null);
			pnlCenterCenter2.setBounds(new Rectangle(0, 275, 880, 234));
			pnlCenterCenter2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
			pnlCenterCenter2.setLayout(null);
			pnlCenterCenter2.add(getScpMstbdtle(), null);
			pnlCenterCenter2.add(lblAblUpl, null);
		}
		return pnlCenterCenter2;
		
	}
	
	private BasePanel getPnlSouth() {
		if (pnlSouth == null) {
			pnlSouth = new BasePanel();
			pnlSouth.setPreferredSize(new Dimension(800, 30));
			pnlSouth.setLayout(null);
			pnlSouth.add(getbtnButRegist(), null);
			pnlSouth.add(getbtnButExit(), null);
		}
		return pnlSouth;
	}
	
	private BasePanel getPnlRect() {
		if (pnlRect == null) {

			pnlRect = new BasePanel();
			pnlRect.setLayout(null);
			pnlRect.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SEARCH_CONDITION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			pnlRect.setBounds(new Rectangle(0, 0, 737, 75));
			pnlRect.add(getTxtBlkKey1EcrNo(), null);
			pnlRect.add(getTxtBlkKey1RevEcr(), null);
			pnlRect.add(getTxtBlkKey1Year(), null);
			pnlRect.add(getTxtBlkKey1Book(), null);
			pnlRect.add(getTxtBlkKey2EcrNo(), null);
			pnlRect.add(getTxtBlkKey2RevEcr(), null);
			pnlRect.add(getTxtBlkKey2Year(), null);
			pnlRect.add(getTxtBlkKey2Book(), null);;
			pnlRect.add(getbtnButSearch(), null);
		}
		return pnlRect;
	}


	/**
	 * This method initializes lblNowDate
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseLabel
	 */
	private BaseLabel getLblNowDate() {
		if (lblNowDate == null) {
			lblNowDate = new BaseLabel();
			lblNowDate.setBounds(new Rectangle(740, 30, 138, 20));
			lblNowDate.setHorizontalAlignment(JTextField.RIGHT);
		}
		return lblNowDate;
	}

	/**
	 * This method initializes lblVer
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseLabel
	 */
	private BaseLabel getLblVer() {
		if (lblVer == null) {
			lblVer = new BaseLabel();
			lblVer.setBounds(new Rectangle(740, 10, 138, 20));
			lblVer.setHorizontalAlignment(JTextField.RIGHT);
			lblVer.setLocalizedToolTipTextKey("");
			lblVer.setForeground(Color.BLACK);
			lblVer.setValue(getBuildVersionString());
		}
		return lblVer;
	}

	/**
	 * This method initializes dbcon	
	 *
	 * @return com.classtechnology.base.common.custom.db.BaseDbConnect
	 */
	private BaseDbConnect getDbcon() {
		if (dbcon == null) {
			dbcon = new BaseDbConnect();
			dbcon.setConnectionInfo(new com.classtechnology.custom.common.CtMapProperty(new java.lang.Object[][] {
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbConnect.INFO_DBTYPE, "Oracle" },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbConnect.INFO_DBNAME, "TEST" },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbConnect.INFO_DRIVER, "oracle.jdbc.driver.OracleDriver" },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbConnect.INFO_PASSWORD, "mstgT" },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbConnect.INFO_USER, "MSTGT" },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbConnect.INFO_URL, "jdbc:oracle:thin:@148.161.237.105:1521:msdt" }
						}));
		}
		return dbcon;
	}
	/**
	 * This method initializes txtBlkKey1EcrNo
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseAlphaNumericTextField
	 */
	private BaseAlphaNumericTextField getTxtBlkKey1EcrNo() {
		if (txtBlkKey1EcrNo == null) {
			txtBlkKey1EcrNo = new BaseAlphaNumericTextField();
			txtBlkKey1EcrNo.setBounds(new Rectangle(7, 22, 125, 20));
			txtBlkKey1EcrNo.setTitle("FROM_ECS");
			txtBlkKey1EcrNo.setValidatorEnabled(true);
			txtBlkKey1EcrNo.setTitleVisible(true);
			txtBlkKey1EcrNo.setAutoCapitalize(true);
			txtBlkKey1EcrNo.setAutoNextFoucus(true);
			txtBlkKey1EcrNo.setLocalizedToolTipTextKey("HINT-ECR_NO");
			txtBlkKey1EcrNo.setTitleWidth(70);
			txtBlkKey1EcrNo.setTitleFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12));
			txtBlkKey1EcrNo.setInputVerifier(new InputVerifier() {
				@Override
				public boolean verify(JComponent arg0) {
					return procBlkKey1EcrNoPostTextItem();
				}
			});
			txtBlkKey1EcrNo.addFocusListener(new FocusAdapter() {				
				@Override
				public void focusLost(FocusEvent arg0) {
					if (!((BaseAlphaNumericTextField)arg0.getComponent()).isEditable()) {
						BaseAlphaNumericTextField txt = (BaseAlphaNumericTextField)arg0.getComponent();
						txt.getCaret().setVisible(false);
					}
				}
				@Override
				public void focusGained(FocusEvent arg0) {
					if (!((BaseAlphaNumericTextField)arg0.getComponent()).isEditable()) {
						BaseAlphaNumericTextField txt = (BaseAlphaNumericTextField)arg0.getComponent();
						txt.getCaret().setVisible(true);
					}
				}
			});
		}
		return txtBlkKey1EcrNo;
	}

	/**
	 * This method initializes txtBlkKey1RevEcr
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseAlphaNumericTextField
	 */
	private BaseAlphaNumericTextField getTxtBlkKey1RevEcr() {
		if (txtBlkKey1RevEcr == null) {
			txtBlkKey1RevEcr = new BaseAlphaNumericTextField();
			txtBlkKey1RevEcr.setBounds(new Rectangle(133, 22, 27, 20));
			txtBlkKey1RevEcr.setTitle("REV_ECR");
			txtBlkKey1RevEcr.setValidatorEnabled(true);
			txtBlkKey1RevEcr.setTitleVisible(false);
			txtBlkKey1RevEcr.setAutoCapitalize(true);
			txtBlkKey1RevEcr.setAutoNextFoucus(true);
			txtBlkKey1RevEcr.setLocalizedToolTipTextKey("HINT-REV_ECR01");
			txtBlkKey1RevEcr.setInputVerifier(new InputVerifier() {
				@Override
				public boolean verify(JComponent arg0) {
					return procBlkKey1RevEcrPostTextItem();
				}
			});
			txtBlkKey1RevEcr.addFocusListener(new FocusAdapter() {				
				@Override
				public void focusLost(FocusEvent arg0) {
					if (!((BaseAlphaNumericTextField)arg0.getComponent()).isEditable()) {
						BaseAlphaNumericTextField txt = (BaseAlphaNumericTextField)arg0.getComponent();
						txt.getCaret().setVisible(false);
					}
				}
				@Override
				public void focusGained(FocusEvent arg0) {
					if (!((BaseAlphaNumericTextField)arg0.getComponent()).isEditable()) {
						BaseAlphaNumericTextField txt = (BaseAlphaNumericTextField)arg0.getComponent();
						txt.getCaret().setVisible(true);
					}
				}
			});
		}
		return txtBlkKey1RevEcr;
	}

	/**
	 * This method initializes txtBlkKey1Year
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseAlphaNumericTextField
	 */
	private BaseAlphaNumericTextField getTxtBlkKey1Year() {
		if (txtBlkKey1Year == null) {
			txtBlkKey1Year = new BaseAlphaNumericTextField();
			txtBlkKey1Year.setBounds(new Rectangle(238, 22, 91, 20));
			txtBlkKey1Year.setTitle("YEAR");
			txtBlkKey1Year.setValidatorEnabled(true);
			txtBlkKey1Year.setTitleVisible(true);
			txtBlkKey1Year.setAutoCapitalize(true);
			txtBlkKey1Year.setAutoNextFoucus(true);
			txtBlkKey1Year.setLocalizedToolTipTextKey("HINT-YEAR");
			txtBlkKey1Year.setTitleWidth(40);
			txtBlkKey1Year.setInputVerifier(new InputVerifier() {
				@Override
				public boolean verify(JComponent arg0) {
					return procBlkKey1YearPostTextItem();
				}
			});
			txtBlkKey1Year.addFocusListener(new FocusAdapter() {				
				@Override
				public void focusLost(FocusEvent arg0) {
					if (!((BaseAlphaNumericTextField)arg0.getComponent()).isEditable()) {
						BaseAlphaNumericTextField txt = (BaseAlphaNumericTextField)arg0.getComponent();
						txt.getCaret().setVisible(false);
					}
				}
				@Override
				public void focusGained(FocusEvent arg0) {
					if (!((BaseAlphaNumericTextField)arg0.getComponent()).isEditable()) {
						BaseAlphaNumericTextField txt = (BaseAlphaNumericTextField)arg0.getComponent();
						txt.getCaret().setVisible(true);
					}
				}
			});
		}
		return txtBlkKey1Year;
	}

	/**
	 * This method initializes txtBlkKey1Book
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseAlphaNumericTextField
	 */
	private BaseAlphaNumericTextField getTxtBlkKey1Book() {
		if (txtBlkKey1Book == null) {
			txtBlkKey1Book = new BaseAlphaNumericTextField();
			txtBlkKey1Book.setBounds(new Rectangle(162, 22, 74, 20));
			txtBlkKey1Book.setTitle("BOOK");
			txtBlkKey1Book.setValidatorEnabled(true);
			txtBlkKey1Book.setTitleVisible(true);
			txtBlkKey1Book.setAutoCapitalize(true);
			txtBlkKey1Book.setAutoNextFoucus(false);
			txtBlkKey1Book.setLocalizedToolTipTextKey("HINT-BOOK");
			txtBlkKey1Book.setTitleWidth(40);
			txtBlkKey1Book.setInputVerifier(new InputVerifier() {
				@Override
				public boolean verify(JComponent arg0) {
					return procBlkKey1BookPostTextItem();
				}
			});
			txtBlkKey1Book.addFocusListener(new FocusAdapter() {				
				@Override
				public void focusLost(FocusEvent arg0) {
					if (!((BaseAlphaNumericTextField)arg0.getComponent()).isEditable()) {
						BaseAlphaNumericTextField txt = (BaseAlphaNumericTextField)arg0.getComponent();
						txt.getCaret().setVisible(false);
					}
				}
				@Override
				public void focusGained(FocusEvent arg0) {
					if (!((BaseAlphaNumericTextField)arg0.getComponent()).isEditable()) {
						BaseAlphaNumericTextField txt = (BaseAlphaNumericTextField)arg0.getComponent();
						txt.getCaret().setVisible(true);
					}
				}
			});
		}
		return txtBlkKey1Book;
	}

	/**
	 * This method initializes txtBlkKey2EcrNo
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseAlphaNumericTextField
	 */
	private BaseAlphaNumericTextField getTxtBlkKey2EcrNo() {
		if (txtBlkKey2EcrNo == null) {
			txtBlkKey2EcrNo = new BaseAlphaNumericTextField();
			txtBlkKey2EcrNo.setBounds(new Rectangle(331, 22, 105, 20));
			txtBlkKey2EcrNo.setTitle("TO_ECS");
			txtBlkKey2EcrNo.setLocalizedToolTipTextKey("HINT-ECR_NO");
			txtBlkKey2EcrNo.setAutoNextFoucus(true);
			txtBlkKey2EcrNo.setAutoCapitalize(true);
			txtBlkKey2EcrNo.setTitleWidth(50);
			txtBlkKey2EcrNo.setInputVerifier(new InputVerifier() {
				@Override
				public boolean verify(JComponent arg0) {
					return procBlkKey2EcrNoPostTextItem();
				}
			});
			txtBlkKey2EcrNo.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					/* DCR 2013/10/01 START */
					if (!((BaseAlphaNumericTextField)arg0.getComponent()).isEditable()) {
						super.focusGained(arg0);
						procBlkKey2FocusGained();
					}
					/* DCR 2013/10/01 END 
					super.focusGained(arg0);
					procBlkKey2FocusGained();
					*/
				}
			});
		}
		return txtBlkKey2EcrNo;
	}

	/**
	 * This method initializes txtBlkKey2RevEcr
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseAlphaNumericTextField
	 */
	private BaseAlphaNumericTextField getTxtBlkKey2RevEcr() {
		if (txtBlkKey2RevEcr == null) {
			txtBlkKey2RevEcr = new BaseAlphaNumericTextField();
			txtBlkKey2RevEcr.setBounds(new Rectangle(437, 22, 27, 20));
			txtBlkKey2RevEcr.setTitle("REV_ECR");
			txtBlkKey2RevEcr.setValidatorEnabled(true);
			txtBlkKey2RevEcr.setTitleVisible(false);
			txtBlkKey2RevEcr.setAutoCapitalize(true);
			txtBlkKey2RevEcr.setAutoNextFoucus(true);
			txtBlkKey2RevEcr.setLocalizedToolTipTextKey("HINT-REV_ECR01");
			txtBlkKey2RevEcr.setInputVerifier(new InputVerifier() {
				@Override
				public boolean verify(JComponent arg0) {
					return procBlkKey2RevEcrPostTextItem();
				}
			});
			txtBlkKey2RevEcr.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					
					/* DCR 2013/10/01 START */
					if (!((BaseAlphaNumericTextField)arg0.getComponent()).isEditable()) {
						super.focusGained(arg0);
						procBlkKey2FocusGained();
					}
					/* DCR 2013/10/01 END 
					super.focusGained(arg0);
					procBlkKey2FocusGained();
					*/
				}
			});
		}
		return txtBlkKey2RevEcr;
	}

	/**
	 * This method initializes txtBlkKey2Year
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseAlphaNumericTextField
	 */
	private BaseAlphaNumericTextField getTxtBlkKey2Year() {
		if (txtBlkKey2Year == null) {
			txtBlkKey2Year = new BaseAlphaNumericTextField();
			txtBlkKey2Year.setBounds(new Rectangle(540, 22, 91, 20));
			txtBlkKey2Year.setTitle("YEAR");
			txtBlkKey2Year.setValidatorEnabled(true);
			txtBlkKey2Year.setTitleVisible(true);
			txtBlkKey2Year.setAutoCapitalize(true);
			txtBlkKey2Year.setAutoNextFoucus(true);
			txtBlkKey2Year.setLocalizedToolTipTextKey("HINT-YEAR");
			txtBlkKey2Year.setTitleWidth(40);
			txtBlkKey2Year.setInputVerifier(new InputVerifier() {
				@Override
				public boolean verify(JComponent arg0) {
					return procBlkKey2YearPostTextItem();
				}
			});
			txtBlkKey2Year.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					/* DCR 2013/10/01 START */
					if (!((BaseAlphaNumericTextField)arg0.getComponent()).isEditable()) {
						super.focusGained(arg0);
						procBlkKey2FocusGained();
					}
					/* DCR 2013/10/01 END 
					super.focusGained(arg0);
					procBlkKey2FocusGained();
					*/
				}
			});
		}
		return txtBlkKey2Year;
	}

	/**
	 * This method initializes txtBlkKey2Book
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseAlphaNumericTextField
	 */
	private BaseAlphaNumericTextField getTxtBlkKey2Book() {
		if (txtBlkKey2Book == null) {
			txtBlkKey2Book = new BaseAlphaNumericTextField();
			txtBlkKey2Book.setBounds(new Rectangle(465, 22, 74, 20));
			txtBlkKey2Book.setTitle("BOOK");
			txtBlkKey2Book.setValidatorEnabled(true);
			txtBlkKey2Book.setTitleVisible(true);
			txtBlkKey2Book.setAutoCapitalize(true);
			txtBlkKey2Book.setAutoNextFoucus(false);
			txtBlkKey2Book.setLocalizedToolTipTextKey("HINT-BOOK");
			txtBlkKey2Book.setTitleWidth(40);
			txtBlkKey2Book.setInputVerifier(new InputVerifier() {
				@Override
				public boolean verify(JComponent arg0) {
					return procBlkKey2BookPostTextItem();
				}
			});
			txtBlkKey2Book.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					/* DCR 2013/10/01 START */
					if (!((BaseAlphaNumericTextField)arg0.getComponent()).isEditable()) {
						super.focusGained(arg0);
						procBlkKey2FocusGained();
					}
					/* DCR 2013/10/01 END 
					super.focusGained(arg0);
					procBlkKey2FocusGained();
					*/
				}
			});
		}
		return txtBlkKey2Book;
	}

	/**
	 * This method initializes txtBlkCtrlInsCnt
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseTextField
	 */
	private BaseTextField getTxtBlkCtrlInsCnt() {
		if (txtBlkCtrlInsCnt == null) {
			txtBlkCtrlInsCnt = new BaseTextField();
			txtBlkCtrlInsCnt.setSize(new Dimension(27, 20));
		}
		return txtBlkCtrlInsCnt;
	}

	/**
	 * This method initializes txtBlkCtrlUpdCnt
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseTextField
	 */
	private BaseTextField getTxtBlkCtrlUpdCnt() {
		if (txtBlkCtrlUpdCnt == null) {
			txtBlkCtrlUpdCnt = new BaseTextField();
			txtBlkCtrlUpdCnt.setSize(new Dimension(33, 20));
		}
		return txtBlkCtrlUpdCnt;
	}

	/**
	 * This method initializes txtBlkCtrlBpUpdFlg
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseTextField
	 */
	private BaseTextField getTxtBlkCtrlBpUpdFlg() {
		if (txtBlkCtrlBpUpdFlg == null) {
			txtBlkCtrlBpUpdFlg = new BaseTextField();
			txtBlkCtrlBpUpdFlg.setSize(new Dimension(34, 20));
		}
		return txtBlkCtrlBpUpdFlg;
	}

	/**
	 * This method initializes txtBlkCtrlEcsEffDate
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseTextField
	 */
	private BaseTextField getTxtBlkCtrlEcsEffDate() {
		if (txtBlkCtrlEcsEffDate == null) {
			txtBlkCtrlEcsEffDate = new BaseTextField();
			txtBlkCtrlEcsEffDate.setSize(new Dimension(37, 20));
		}
		return txtBlkCtrlEcsEffDate;
	}

	/**
	 * This method initializes txtBlkCtrlBpStartDate
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseTextField
	 */
	private BaseTextField getTxtBlkCtrlBpStartDate() {
		if (txtBlkCtrlBpStartDate == null) {
			txtBlkCtrlBpStartDate = new BaseTextField();
			txtBlkCtrlBpStartDate.setSize(new Dimension(32, 20));
		}
		return txtBlkCtrlBpStartDate;
	}

	/**
	 * This method initializes txtBlkCtrlBpStartEcrNo
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseTextField
	 */
	private BaseTextField getTxtBlkCtrlBpStartEcrNo() {
		if (txtBlkCtrlBpStartEcrNo == null) {
			txtBlkCtrlBpStartEcrNo = new BaseTextField();
			txtBlkCtrlBpStartEcrNo.setSize(new Dimension(23, 20));
		}
		return txtBlkCtrlBpStartEcrNo;
	}

	/**
	 * This method initializes txtBlkCtrlBpStartRevEcr
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseTextField
	 */
	private BaseTextField getTxtBlkCtrlBpStartRevEcr() {
		if (txtBlkCtrlBpStartRevEcr == null) {
			txtBlkCtrlBpStartRevEcr = new BaseTextField();
			txtBlkCtrlBpStartRevEcr.setSize(new Dimension(27, 20));
		}
		return txtBlkCtrlBpStartRevEcr;
	}

	/**
	 * This method initializes txtBlkCtrlBpStopDate
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseTextField
	 */
	private BaseTextField getTxtBlkCtrlBpStopDate() {
		if (txtBlkCtrlBpStopDate == null) {
			txtBlkCtrlBpStopDate = new BaseTextField();
			txtBlkCtrlBpStopDate.setSize(new Dimension(28, 20));
		}
		return txtBlkCtrlBpStopDate;
	}

	/**
	 * This method initializes txtBlkCtrlBpStopEcrNo
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseTextField
	 */
	private BaseTextField getTxtBlkCtrlBpStopEcrNo() {
		if (txtBlkCtrlBpStopEcrNo == null) {
			txtBlkCtrlBpStopEcrNo = new BaseTextField();
			txtBlkCtrlBpStopEcrNo.setSize(new Dimension(34, 20));
		}
		return txtBlkCtrlBpStopEcrNo;
	}

	/**
	 * This method initializes txtBlkCtrlBpStopRevEcr
	 * 
	 * @return com.classtechnology.base.common.custom.gui.BaseTextField
	 */
	private BaseTextField getTxtBlkCtrlBpStopRevEcr() {
		if (txtBlkCtrlBpStopRevEcr == null) {
			txtBlkCtrlBpStopRevEcr = new BaseTextField();
			txtBlkCtrlBpStopRevEcr.setSize(new Dimension(29, 20));
		}
		return txtBlkCtrlBpStopRevEcr;
	}


	/**
     * This method initializes tblMstbecsu
	 * 
	 * @return com.classtechnology.base.common.custom.db.BaseDbGroupableTable
	 */
	private BaseDbGroupableTable getTblMstbecsu() {
		if (tblMstbecsu == null) {
			tblMstbecsu = new BaseDbGroupableTable();
			tblMstbecsu.setColumnAccessSetting(new com.classtechnology.custom.gui.CtTableColumnAccessSetting(new java.lang.Object[][] {
							new java.lang.Object[] { com.classtechnology.custom.gui.CtTableColumnAccessSetting.PROP_EDITABLE_COLUMNS, new java.lang.String[] { "INTENT" } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtTableColumnAccessSetting.PROP_DISPLAY_COLUMNS, new java.lang.String[] { "+/-", "Part", "Upc", "Fna", "Usage", "Qty", "INTENT", "Message" } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtTableColumnAccessSetting.PROP_VISIBLE_COLUMNS, new java.lang.String[] { "+/-", "Part", "Upc", "Fna", "Usage", "Qty", "INTENT", "Message" } }
						}));
			tblMstbecsu.setQuerySetting(new com.classtechnology.custom.db.CtDbQuerySetting(new java.lang.Object[][] {
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_DISPLAY_COLUMN_NAMES, new java.lang.String[] { "+/-", "ECR_NO", "REV_ECR", "YEAR", "BOOK", "Part", "Upc", "Fna", "Usage", "Qty", "START_STOP_FLG", "INTENT", "Message" } },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_SELECT_COLUMN_NAMES, new java.lang.String[] { "", "ECR_NO", "REV_ECR", "YEAR", "BOOK", "PART_NO", "UPC", "FNA", "USAGE_CODE", "UNIT_QTY", "START_STOP_FLG", "", "" } },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_SELECT_TABLE_NAMES, new java.lang.String[] { "", "MSTBECSU", "MSTBECSU", "MSTBECSU", "MSTBECSU", "MSTBECSU", "MSTBECSU", "MSTBECSU", "MSTBECSU", "MSTBECSU", "MSTBECSU", "", "" } },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_MAXIMUM_LISTSIZE, com.classtechnology.custom.common.CtIntegerCache.valueOf(1000) },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_KEY_COLUMN_NAMES, null },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_PAGESIZE, com.classtechnology.custom.common.CtIntegerCache.valueOf(-1) },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_DISTINCT_SELECT, java.lang.Boolean.FALSE },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_DB_NAME, null },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_DO_CONTROL_LISTSIZE, java.lang.Boolean.TRUE },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_INPUT_PARAM_TYPES, null },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_LIMIT_RECORD_SIZE, com.classtechnology.custom.common.CtIntegerCache.valueOf(10000) },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_CHANGE_IGNORED_COLUMN_NAMES, null },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_REQUIRED_COLUMN_NAMES, new java.lang.String[] {  } },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_PARAMETER_ESCAPE_STRING, "#" },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_WHERE_CONDITION_PHRASE, null },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_DO_PAGING, java.lang.Boolean.FALSE },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_OTHER_CONDITION_PHRASE, "order by UPC, FNA, UNIT_QTY, PART_NO, USAGE_CODE" },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_AUTO_CREATE_PAGINGCONTROLLER, java.lang.Boolean.FALSE }
						}));
			tblMstbecsu.setColumnLayoutInfo(new com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo(new java.lang.Object[][] {
							new java.lang.Object[] { com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo.PROP_CHILD_COUNT, new int[] { 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo.PROP_ADJUST_NODE_INDICES, new int[] {  } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo.PROP_WIDTHS, new int[] { 1016, 90, 69, 55, 55, 55, 27, 27, 230, 75, 75, 75, 75, 75 } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo.PROP_ADJUST_NODE_LEVEL_COUNT, new int[] {  } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo.PROP_MODEL_INDICES, new int[] { -2, 5, 6, 7, 8, 9, 0, 11, 12, 4, 2, 3, 1, 10 } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo.PROP_IDENTIFIERS, new java.lang.Object[] { null, "Part", "Upc", "Fna", "Usage", "Qty", "+/-", "INTENT", "Message", "BOOK", "REV_ECR", "YEAR", "ECR_NO", "START_STOP_FLG" } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo.PROP_DATA_SIZES, new int[] { 0, 20 } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo.PROP_HEADER_SIZES, new int[] { 0, 20 } }
						}));
			tblMstbecsu.setPropertyPersistenceSetting(new com.classtechnology.custom.propertyPersistence.CtPropertyPersistenceSetting(new java.lang.Object[][] {
							new java.lang.Object[] { com.classtechnology.custom.propertyPersistence.CtPropertyPersistenceSetting.PROP_INSTANCE_ID, "BaseDbGroupableTable-00846FB68C2417DD5149DC45F31" },
							new java.lang.Object[] { com.classtechnology.custom.propertyPersistence.CtPropertyPersistenceSetting.PROP_PERSISTENT_PROPERTY_NAMES, new java.lang.String[] { "columnAccessSetting", "columnLayoutInfo", "rowHeaderWidth" } }
						}));
			tblMstbecsu.setTableName("USAGE POINTER");
			tblMstbecsu.saveInitialColumnLayoutInfo();
			tblMstbecsu.setDbConnect(getDbcon());
		}
		return tblMstbecsu;
	}

	/**
	 * This method initializes ccpMstbecsuPartNo
	 * 
	 * @return com.classtechnology.base.common.custom.gui.table.BaseTextFieldCellComponent
	 */
	private BaseAlphaNumericTextFieldCellComponent getCcpMstbecsuPartNo() {
		if (ccpMstbecsuPartNo == null) {
			ccpMstbecsuPartNo = new BaseAlphaNumericTextFieldCellComponent();
			ccpMstbecsuPartNo.setSize(new Dimension(83, 17));
			ccpMstbecsuPartNo.setTitle("Part");
			ccpMstbecsuPartNo.setColumnNameInfo(new com.classtechnology.custom.gui.table.CtTableColumnNameInfo("Part"));
			ccpMstbecsuPartNo.setLocalizedToolTipTextKey("HINT-PART_NO");
			ccpMstbecsuPartNo.setAutoCapitalize(true);
			ccpMstbecsuPartNo.setTable(getTblMstbecsu());
		}
		return ccpMstbecsuPartNo;
	}

	/**
	 * This method initializes ccpMstbecsuUpc
	 * 
	 * @return com.classtechnology.base.common.custom.gui.table.BaseAlphaNumericTextFieldCellComponent
	 */
	private BaseAlphaNumericTextFieldCellComponent getCcpMstbecsuUpc() {
		if (ccpMstbecsuUpc == null) {
			ccpMstbecsuUpc = new BaseAlphaNumericTextFieldCellComponent();
			ccpMstbecsuUpc.setSize(new Dimension(59, 17));
			ccpMstbecsuUpc.setTitle("Upc");
			ccpMstbecsuUpc.setColumnNameInfo(new com.classtechnology.custom.gui.table.CtTableColumnNameInfo("Upc"));
			ccpMstbecsuUpc.setLocalizedToolTipTextKey("HINT-UPC");
			ccpMstbecsuUpc.setAutoCapitalize(true);
			ccpMstbecsuUpc.setTable(getTblMstbecsu());
			ccpMstbecsuUpc.setInputVerifier(new InputVerifier() {
				
				@Override
				public boolean verify(JComponent arg0) {
					return procBlkEcsu1UpcPostTextItem();
				}
			});
		}
		return ccpMstbecsuUpc;
	}

	/**
	 * This method initializes ccpMstbecsuFna
	 * 
	 * @return com.classtechnology.base.common.custom.gui.table.BaseAlphaNumericTextFieldCellComponent
	 */
	private BaseAlphaNumericTextFieldCellComponent getCcpMstbecsuFna() {
		if (ccpMstbecsuFna == null) {
			ccpMstbecsuFna = new BaseAlphaNumericTextFieldCellComponent();
			ccpMstbecsuFna.setSize(new Dimension(45, 17));
			ccpMstbecsuFna.setTitle("Fna");
			ccpMstbecsuFna.setColumnNameInfo(new com.classtechnology.custom.gui.table.CtTableColumnNameInfo("Fna"));
			ccpMstbecsuFna.setLocalizedToolTipTextKey("HINT-FNA");
			ccpMstbecsuFna.setAutoCapitalize(true);
			ccpMstbecsuFna.setTable(getTblMstbecsu());
		}
		return ccpMstbecsuFna;
	}

	/**
	 * This method initializes ccpMstbecsuUsageCode
	 * 
	 * @return com.classtechnology.base.common.custom.gui.table.BaseAlphaNumericTextFieldCellComponent
	 */
	private BaseAlphaNumericTextFieldCellComponent getCcpMstbecsuUsageCode() {
		if (ccpMstbecsuUsageCode == null) {
			ccpMstbecsuUsageCode = new BaseAlphaNumericTextFieldCellComponent();
			ccpMstbecsuUsageCode.setSize(new Dimension(45, 17));
			ccpMstbecsuUsageCode.setTitle("Usage");
			ccpMstbecsuUsageCode.setColumnNameInfo(new com.classtechnology.custom.gui.table.CtTableColumnNameInfo("Usage"));
			ccpMstbecsuUsageCode.setLocalizedToolTipTextKey("HINT-USAGE_CODE");
			ccpMstbecsuUsageCode.setAutoCapitalize(true);
			ccpMstbecsuUsageCode.setTable(getTblMstbecsu());
			ccpMstbecsuUsageCode.setInputVerifier(new InputVerifier() {
				@Override
				public boolean verify(JComponent arg0) {
					return procBlkEcsu1UsageCodePostTextItem();
				}
			});
		}
		return ccpMstbecsuUsageCode;
	}

	/**
	 * This method initializes ccpMstbecsuUnitQty
	 * 
	 * @return com.classtechnology.base.common.custom.gui.table.BaseAlphaNumericTextFieldCellComponent
	 */
	private BaseAlphaNumericTextFieldCellComponent getCcpMstbecsuUnitQty() {
		if (ccpMstbecsuUnitQty == null) {
			ccpMstbecsuUnitQty = new BaseAlphaNumericTextFieldCellComponent();
			ccpMstbecsuUnitQty.setSize(new Dimension(45, 17));
			ccpMstbecsuUnitQty.setTitle("Qty");
			ccpMstbecsuUnitQty.setColumnNameInfo(new com.classtechnology.custom.gui.table.CtTableColumnNameInfo("Qty"));
			ccpMstbecsuUnitQty.setLocalizedToolTipTextKey("HINT-UNIT_QTY");
			ccpMstbecsuUnitQty.setAutoCapitalize(true);
			ccpMstbecsuUnitQty.setTable(getTblMstbecsu());
		}
		return ccpMstbecsuUnitQty;
	}

	/**
	 * This method initializes ccpMstbecsuStartStop
	 * 
	 * @return com.classtechnology.base.common.custom.gui.table.BaseAlphaNumericTextFieldCellComponent
	 */
	private BaseAlphaNumericTextFieldCellComponent getCcpMstbecsuStartStop() {
		if (ccpMstbecsuStartStop == null) {
			ccpMstbecsuStartStop = new BaseAlphaNumericTextFieldCellComponent();
			ccpMstbecsuStartStop.setSize(new Dimension(16, 17));
			ccpMstbecsuStartStop.setTitle("START_STOP_FLG");
			ccpMstbecsuStartStop.setColumnNameInfo(new com.classtechnology.custom.gui.table.CtTableColumnNameInfo("START_STOP_FLG"));
			ccpMstbecsuStartStop.setLocalizedToolTipTextKey("HINT-START_STOP");
			ccpMstbecsuStartStop.setAutoCapitalize(true);
			ccpMstbecsuStartStop.setTable(getTblMstbecsu());
		}
		return ccpMstbecsuStartStop;
	}

	/**
	 * This method initializes scpMstbecsu
	 *
	 * @return com.classtechnology.base.common.custom.gui.container.BaseScrollPane
	 */
	private BaseScrollPane getScpMstbecsu() {
		if (scpMstbecsu == null) {
			scpMstbecsu = new BaseScrollPane();
//			scpMstbecsu.setBounds(new Rectangle(4, 32, 665, 166));
			scpMstbecsu.setBounds(new Rectangle(4, 32, 665, 206));
			scpMstbecsu.setViewportView(getTblMstbecsu());
			scpMstbecsu.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return scpMstbecsu;
	}
	/**
   * This method initializes tblMstbdtle
	 * 
	 * @return com.classtechnology.base.common.custom.db.BaseDbGroupableTable
	 */
	private BaseDbGroupableTable getTblMstbdtle() {
		if (tblMstbdtle == null) {
			tblMstbdtle = new BaseDbGroupableTable();
			tblMstbdtle.setQuerySetting(new com.classtechnology.custom.db.CtDbQuerySetting(new java.lang.Object[][] {
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_DISPLAY_COLUMN_NAMES, new java.lang.String[] { "+/-", "ECR_NO", "REV_ECR", "YEAR", "BOOK", "Part", "Seq", "Dtl-Part", "Upc", "Fna", "Qty", "START_STOP_FLG", "INTENT", "Message" } },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_SELECT_COLUMN_NAMES, new java.lang.String[] { "", "ECR_NO", "REV_ECR", "YEAR", "BOOK", "PART_NO", "DETAIL_SEQ", "DETAIL_PART", "DETAIL_UPC", "DETAIL_FNA", "DETAIL_QTY", "START_STOP_FLG", "", "" } },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_SELECT_TABLE_NAMES, new java.lang.String[] { "", "MSTBDTLE", "MSTBDTLE", "MSTBDTLE", "MSTBDTLE", "MSTBDTLE", "MSTBDTLE", "MSTBDTLE", "MSTBDTLE", "MSTBDTLE", "MSTBDTLE", "MSTBDTLE", "", "" } },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_KEY_COLUMN_NAMES, null },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_MAXIMUM_LISTSIZE, com.classtechnology.custom.common.CtIntegerCache.valueOf(1000) },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_PAGESIZE, com.classtechnology.custom.common.CtIntegerCache.valueOf(-1) },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_DISTINCT_SELECT, java.lang.Boolean.FALSE },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_DB_NAME, null },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_DO_CONTROL_LISTSIZE, java.lang.Boolean.TRUE },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_LIMIT_RECORD_SIZE, com.classtechnology.custom.common.CtIntegerCache.valueOf(10000) },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_INPUT_PARAM_TYPES, null },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_REQUIRED_COLUMN_NAMES, new java.lang.String[] {  } },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_CHANGE_IGNORED_COLUMN_NAMES, null },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_PARAMETER_ESCAPE_STRING, "#" },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_WHERE_CONDITION_PHRASE, null },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_DO_PAGING, java.lang.Boolean.FALSE },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_OTHER_CONDITION_PHRASE, "order by PART_NO, DETAIL_SEQ, DETAIL_UPC, DETAIL_FNA, DETAIL_QTY, DETAIL_PART" },
							new java.lang.Object[] { com.classtechnology.custom.db.CtDbQuerySetting.PROP_AUTO_CREATE_PAGINGCONTROLLER, java.lang.Boolean.FALSE }
						}));
			tblMstbdtle.setColumnAccessSetting(new com.classtechnology.custom.gui.CtTableColumnAccessSetting(new java.lang.Object[][] {
							new java.lang.Object[] { com.classtechnology.custom.gui.CtTableColumnAccessSetting.PROP_EDITABLE_COLUMNS, new java.lang.String[] { "INTENT" } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtTableColumnAccessSetting.PROP_DISPLAY_COLUMNS, new java.lang.String[] { "+/-", "Part", "Seq", "Dtl-Part", "Upc", "Fna", "Qty", "INTENT", "Message" } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtTableColumnAccessSetting.PROP_VISIBLE_COLUMNS, new java.lang.String[] { "+/-", "Part", "Seq", "Dtl-Part", "Upc", "Fna", "Qty", "INTENT", "Message" } }
						}));
			tblMstbdtle.setColumnLayoutInfo(new com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo(new java.lang.Object[][] {
							new java.lang.Object[] { com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo.PROP_CHILD_COUNT, new int[] { 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo.PROP_ADJUST_NODE_INDICES, new int[] {  } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo.PROP_WIDTHS, new int[] { 1016, 90, 55, 90, 69, 55, 55, 27, 27, 232, 75, 75, 75, 75, 75 } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo.PROP_ADJUST_NODE_LEVEL_COUNT, new int[] {  } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo.PROP_MODEL_INDICES, new int[] { -2, 5, 6, 7, 8, 9, 10, 0, 12, 13, 11, 4, 3, 2, 1 } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo.PROP_IDENTIFIERS, new java.lang.Object[] { null, "Part", "Seq", "Dtl-Part", "Upc", "Fna", "Qty", "+/-", "INTENT", "Message", "START_STOP_FLG", "BOOK", "YEAR", "REV_ECR", "ECR_NO" } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo.PROP_DATA_SIZES, new int[] { 0, 20 } },
							new java.lang.Object[] { com.classtechnology.custom.gui.CtGroupableTableColumnLayoutInfo.PROP_HEADER_SIZES, new int[] { 0, 20 } }
						}));
			tblMstbdtle.setPropertyPersistenceSetting(new com.classtechnology.custom.propertyPersistence.CtPropertyPersistenceSetting(new java.lang.Object[][] {
							new java.lang.Object[] { com.classtechnology.custom.propertyPersistence.CtPropertyPersistenceSetting.PROP_INSTANCE_ID, "BaseDbGroupableTable-0086B68A9A628370CB0F6E167CA" },
							new java.lang.Object[] { com.classtechnology.custom.propertyPersistence.CtPropertyPersistenceSetting.PROP_PERSISTENT_PROPERTY_NAMES, new java.lang.String[] { "columnAccessSetting", "columnLayoutInfo", "rowHeaderWidth" } }
						}));
			tblMstbdtle.setTableName("DETAIL POINTER");
			tblMstbdtle.saveInitialColumnLayoutInfo();
			tblMstbdtle.setDbConnect(getDbcon());
			tblMstbdtle.setInsertMode(false);
		}
		return tblMstbdtle;
	}

	/**
	 * This method initializes scpMstbdtle
	 *
	 * @return com.classtechnology.base.common.custom.gui.container.BaseScrollPane
	 */
	private BaseScrollPane getScpMstbdtle() {
		if (scpMstbdtle == null) {
			scpMstbdtle = new BaseScrollPane();
			scpMstbdtle.setBounds(new Rectangle(4, 30, 756, 194));
			scpMstbdtle.setViewportView(getTblMstbdtle());
			scpMstbdtle.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return scpMstbdtle;
	}
	/**
	 * This method initializes dcmBlkEcsu1
	 * 
	 * @return com.classtechnology.custom.db.CtDynamicConditionManager
	 */
	private CtDynamicConditionManager getDcmBlkEcsu1Key2() {
		if (dcmBlkEcsu1Key2 == null) {
			dcmBlkEcsu1Key2 = new CtDynamicConditionManager();
			dcmBlkEcsu1Key2.setDynamicConditionInfo(new com.classtechnology.custom.db.CtDynamicConditionInfo(new java.lang.Object[][] {
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_NULL_VALUE_CONDITION_PHRASE_LIST, new java.lang.String[] { "ECR_NO = ? ", " YEAR = ? ", " BOOK = ? AND (START_STOP_FLG = 'A'       OR START_STOP_FLG = 'D')" } },
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_CONDITION_PHRASE_LIST, new java.lang.String[] { "ECR_NO = ? ", " YEAR = ? ", " BOOK = ? AND (START_STOP_FLG = 'A'       OR START_STOP_FLG = 'D')" } },
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_NAME_LIST_RELATED_CONDITION_INFO, new java.lang.String[] { "CND_ECR_NO", "CND_YEAR", "CND_BOOK" } },
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_PARAMETER_TYPE_LIST, new int[] { 1, 1, 1 } },
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_OPERATOR, "AND" }
			}));
		}
		return dcmBlkEcsu1Key2;
	}

	/**
	 * This method initializes dcmBlkEcsu1
	 * 
	 * @return com.classtechnology.custom.db.CtDynamicConditionManager
	 */
	private CtDynamicConditionManager getDcmBlkEcsu1Key1() {
		if (dcmBlkEcsu1Key1 == null) {
			dcmBlkEcsu1Key1 = new CtDynamicConditionManager();
			dcmBlkEcsu1Key1.setDynamicConditionInfo(new com.classtechnology.custom.db.CtDynamicConditionInfo(new java.lang.Object[][] {
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_NULL_VALUE_CONDITION_PHRASE_LIST, new java.lang.String[] { "ECR_NO = ? ", "REV_ECR = NVL(?,' ')", " YEAR = ? ", " BOOK = ? AND (START_STOP_FLG = '-'      OR     START_STOP_FLG = '+')" } },
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_CONDITION_PHRASE_LIST, new java.lang.String[] { "ECR_NO = ? ", "REV_ECR = NVL(?,' ')", " YEAR = ? ", " BOOK = ? AND (START_STOP_FLG = '-'      OR     START_STOP_FLG = '+')" } },
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_NAME_LIST_RELATED_CONDITION_INFO, new java.lang.String[] { "CND_ECR_NO", "CND_REV_ECR", "CND_YEAR", "CND_BOOK" } },
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_PARAMETER_TYPE_LIST, new int[] { 1, 1, 1, 1 } },
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_OPERATOR, "AND" }
			}));
		}
		return dcmBlkEcsu1Key1;
	}

	/**
	 * This method initializes relCndEcsu1BlkKey1EcrNo
	 * 
	 * @return com.classtechnology.custom.relation.CtNamedComponentRelation
	 */
	private CtNamedComponentRelation getRelCndEcsu1BlkKey1EcrNo() {
		if (relCndEcsu1BlkKey1EcrNo == null) {
			relCndEcsu1BlkKey1EcrNo = new CtNamedComponentRelation();
			relCndEcsu1BlkKey1EcrNo.setRelationNameInfo(new com.classtechnology.custom.relation.CtRelationNameInfo("CND_ECR_NO"));
			relCndEcsu1BlkKey1EcrNo.setComponent(getTxtBlkKey1EcrNo());
			relCndEcsu1BlkKey1EcrNo.setRelationSet(getDcmBlkEcsu1Key1());
		}
		return relCndEcsu1BlkKey1EcrNo;
	}

	/**
	 * This method initializes relCndEcsu1BlkKey1Year
	 * 
	 * @return com.classtechnology.custom.relation.CtNamedComponentRelation
	 */
	private CtNamedComponentRelation getRelCndEcsu1BlkKey1Year() {
		if (relCndEcsu1BlkKey1Year == null) {
			relCndEcsu1BlkKey1Year = new CtNamedComponentRelation();
			relCndEcsu1BlkKey1Year.setRelationNameInfo(new com.classtechnology.custom.relation.CtRelationNameInfo("CND_YEAR"));
			relCndEcsu1BlkKey1Year.setComponent(getTxtBlkKey1Year());
			relCndEcsu1BlkKey1Year.setRelationSet(getDcmBlkEcsu1Key1());
		}
		return relCndEcsu1BlkKey1Year;
	}

	/**
	 * This method initializes relCndEcsu1BlkKey1Book
	 * 
	 * @return com.classtechnology.custom.relation.CtNamedComponentRelation
	 */
	private CtNamedComponentRelation getRelCndEcsu1BlkKey1Book() {
		if (relCndEcsu1BlkKey1Book == null) {
			relCndEcsu1BlkKey1Book = new CtNamedComponentRelation();
			relCndEcsu1BlkKey1Book.setRelationNameInfo(new com.classtechnology.custom.relation.CtRelationNameInfo("CND_BOOK"));
			relCndEcsu1BlkKey1Book.setComponent(getTxtBlkKey1Book());
			relCndEcsu1BlkKey1Book.setRelationSet(getDcmBlkEcsu1Key1());
		}
		return relCndEcsu1BlkKey1Book;
	}

	/**
	 * This method initializes relCndEcsu1BlkKey1RevEcr
	 * 
	 * @return com.classtechnology.custom.relation.CtNamedComponentRelation
	 */
	private CtNamedComponentRelation getRelCndEcsu1BlkKey1RevEcr() {
		if (relCndEcsu1BlkKey1RevEcr == null) {
			relCndEcsu1BlkKey1RevEcr = new CtNamedComponentRelation();
			relCndEcsu1BlkKey1RevEcr.setRelationNameInfo(new com.classtechnology.custom.relation.CtRelationNameInfo("CND_REV_ECR"));
			relCndEcsu1BlkKey1RevEcr.setComponent(getTxtBlkKey1RevEcr());
			relCndEcsu1BlkKey1RevEcr.setRelationSet(getDcmBlkEcsu1Key1());
		}
		return relCndEcsu1BlkKey1RevEcr;
	}

	/**
	 * This method initializes dcmBlkDtle1Key2
	 * 
	 * @return com.classtechnology.custom.db.CtDynamicConditionManager
	 */
	private CtDynamicConditionManager getDcmBlkDtle1Key2() {
		if (dcmBlkDtle1Key2 == null) {
			dcmBlkDtle1Key2 = new CtDynamicConditionManager();
			dcmBlkDtle1Key2.setDynamicConditionInfo(new com.classtechnology.custom.db.CtDynamicConditionInfo(new java.lang.Object[][] {
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_NULL_VALUE_CONDITION_PHRASE_LIST, new java.lang.String[] { "ECR_NO = ? ", " YEAR = NVL ( ? , '   ' ) ", " BOOK = NVL ( ? , '  ' )  AND  ( START_STOP_FLG = 'A'  OR  START_STOP_FLG = 'D' )  " } },
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_CONDITION_PHRASE_LIST, new java.lang.String[] { "ECR_NO = ? ", " YEAR = NVL ( ? , '   ' ) ", " BOOK = NVL ( ? , '  ' )  AND  ( START_STOP_FLG = 'A'  OR  START_STOP_FLG = 'D' )  " } },
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_NAME_LIST_RELATED_CONDITION_INFO, new java.lang.String[] { "CND_ECR_NO", "CND_YEAR", "CND_BOOK" } },
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_PARAMETER_TYPE_LIST, new int[] { 1, 1, 1 } },
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_OPERATOR, "AND" }
			}));
		}
		return dcmBlkDtle1Key2;
	}

	/**
	 * This method initializes dcmBlkDtle1Key1
	 * 
	 * @return com.classtechnology.custom.db.CtDynamicConditionManager
	 */
	private CtDynamicConditionManager getDcmBlkDtle1Key1() {
		if (dcmBlkDtle1Key1 == null) {
			dcmBlkDtle1Key1 = new CtDynamicConditionManager();
			dcmBlkDtle1Key1.setDynamicConditionInfo(new com.classtechnology.custom.db.CtDynamicConditionInfo(new java.lang.Object[][] {
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_NULL_VALUE_CONDITION_PHRASE_LIST, new java.lang.String[] { "ECR_NO = ? ", " REV_ECR = NVL ( ? , ' ' ) ", " YEAR = NVL ( ? , '   ' ) ", " BOOK = NVL ( ? , '  ' )  AND (START_STOP_FLG = '-' OR START_STOP_FLG = '+')" } },
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_CONDITION_PHRASE_LIST, new java.lang.String[] { "ECR_NO = ? ", " REV_ECR = NVL ( ? , ' ' ) ", " YEAR = NVL ( ? , '   ' ) ", " BOOK = NVL ( ? , '  ' )  AND (START_STOP_FLG = '-' OR START_STOP_FLG = '+')" } },
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_NAME_LIST_RELATED_CONDITION_INFO, new java.lang.String[] { "CND_ECR_NO", "CND_REV_ECR", "CND_YEAR", "CND_BOOK" } },
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_PARAMETER_TYPE_LIST, new int[] { 1, 1, 1, 1 } },
				new java.lang.Object[] { com.classtechnology.custom.db.CtDynamicConditionInfo.PROP_OPERATOR, "AND" }
			}));
		}
		return dcmBlkDtle1Key1;
	}
	private BaseButton getbtnButSearch() {
		if (btnSearch  == null) {
			btnSearch = new BaseButton();
			btnSearch.setBounds(new Rectangle(635, 18, 95, 24));
			btnSearch.setFunction(getFuncQuery());
			btnSearch.setLocalizedLabelKey("SEARCH");
			btnSearch.setVisbleOpenMode(BaseWindowOpenMode.values());

		}
		return btnSearch ;
	}

	private BaseButton getbtnButInsert() {
		if (btnButInsert  == null) {
			btnButInsert = new BaseButton();
			btnButInsert.setBounds(new Rectangle(730, 5, 145, 24));
			btnButInsert.setFunction(getFuncInsert());
			btnButInsert.setLocalizedLabelKey("NEW_POINTER");

		}
		return btnButInsert ;
	}
	private BaseButton getbtnButDelete() {
		if (btnDelete == null) {
			btnDelete  = new BaseButton();
			btnDelete.setBounds(new Rectangle(4, 242, 110, 24));
			btnDelete.setFunction(getFuncDelete());
			btnDelete.setLocalizedLabelKey("DELETE");
		}
		return btnDelete  ;
	}
	private BaseButton getbtnButRegist() {
		if (btnButRegist  == null) {
			btnButRegist = new BaseButton();
			btnButRegist.setLocalizedLabelKey("REGIST");
			btnButRegist.setFunction(getFuncSave());
			btnButRegist.setBounds(new Rectangle(652, 3, 110, 24));
		}
		return btnButRegist ;
	}
	private BaseWindowCloseButton getbtnButExit() {
		if (btnButExit  == null) {
			btnButExit  =  new BaseWindowCloseButton();
			btnButExit.setBounds(new Rectangle(767, 3, 110, 24));
			btnButExit.setLocalizedLabelKey("EXIT");
			btnButExit.setLocalizedToolTipTextKey("");

		}
		return btnButExit ;
	}
	
	/**
	 * This method initializes relCndDtle1BlkKey1EcrNo
	 * 
	 * @return com.classtechnology.custom.relation.CtNamedComponentRelation
	 */
	private CtNamedComponentRelation getRelCndDtle1BlkKey1EcrNo() {
		if (relCndDtle1BlkKey1EcrNo == null) {
			relCndDtle1BlkKey1EcrNo = new CtNamedComponentRelation();
			relCndDtle1BlkKey1EcrNo.setRelationNameInfo(new com.classtechnology.custom.relation.CtRelationNameInfo("CND_ECR_NO"));
			relCndDtle1BlkKey1EcrNo.setComponent(getTxtBlkKey1EcrNo());
			relCndDtle1BlkKey1EcrNo.setRelationSet(getDcmBlkDtle1Key1());
		}
		return relCndDtle1BlkKey1EcrNo;
	}

	/**
	 * This method initializes relCndDtle1BlkKey1Year
	 * 
	 * @return com.classtechnology.custom.relation.CtNamedComponentRelation
	 */
	private CtNamedComponentRelation getRelCndDtle1BlkKey1Year() {
		if (relCndDtle1BlkKey1Year == null) {
			relCndDtle1BlkKey1Year = new CtNamedComponentRelation();
			relCndDtle1BlkKey1Year.setRelationNameInfo(new com.classtechnology.custom.relation.CtRelationNameInfo("CND_YEAR"));
			relCndDtle1BlkKey1Year.setComponent(getTxtBlkKey1Year());
			relCndDtle1BlkKey1Year.setRelationSet(getDcmBlkDtle1Key1());
		}
		return relCndDtle1BlkKey1Year;
	}

	/**
	 * This method initializes relCndDtle1BlkKey1Book
	 * 
	 * @return com.classtechnology.custom.relation.CtNamedComponentRelation
	 */
	private CtNamedComponentRelation getRelCndDtle1BlkKey1Book() {
		if (relCndDtle1BlkKey1Book == null) {
			relCndDtle1BlkKey1Book = new CtNamedComponentRelation();
			relCndDtle1BlkKey1Book.setRelationNameInfo(new com.classtechnology.custom.relation.CtRelationNameInfo("CND_BOOK"));
			relCndDtle1BlkKey1Book.setComponent(getTxtBlkKey1Book());
			relCndDtle1BlkKey1Book.setRelationSet(getDcmBlkDtle1Key1());
		}
		return relCndDtle1BlkKey1Book;
	}

	/**
	 * This method initializes relCndDtle1BlkKey1RevEcr
	 * 
	 * @return com.classtechnology.custom.relation.CtNamedComponentRelation
	 */
	private CtNamedComponentRelation getRelCndDtle1BlkKey1RevEcr() {
		if (relCndDtle1BlkKey1RevEcr == null) {
			relCndDtle1BlkKey1RevEcr = new CtNamedComponentRelation();
			relCndDtle1BlkKey1RevEcr.setRelationNameInfo(new com.classtechnology.custom.relation.CtRelationNameInfo("CND_REV_ECR"));
			relCndDtle1BlkKey1RevEcr.setComponent(getTxtBlkKey1RevEcr());
			relCndDtle1BlkKey1RevEcr.setRelationSet(getDcmBlkDtle1Key1());
		}
		return relCndDtle1BlkKey1RevEcr;
	}



	/**
	 * This method initializes funcQuery
	 * 
	 * @return com.classtechnology.base.common.custom.function.BaseUserFunction
	 */
	private BaseUserFunction getFuncQuery() {
		if (funcQuery == null) {
			funcQuery = new BaseUserFunction();
			funcQuery.addActionListener(new CtActionListener() {
				@Override
				public void actionPerformed(CtActionEvent arg0) {
					// DeveloperのWHEN-BUTTON-PRESSED TriggerのロジックをCallします。
					procBlkTbQueryWhenButtonPressed();
				}
			});
			funcQuery.addFunctionListener(new CtFunctionAdapter() {

				/* (non-Javadoc)
				 * @see com.classtechnology.custom.function.CtFunctionAdapter#done(com.classtechnology.custom.function.CtFunctionSuccessEvent)
				 */
				@Override
				public void done(CtFunctionSuccessEvent e) {
					super.done(e);
					// 時間更新
					ISZFunctionUtil.setSystemDataTime(lblNowDate);
				}
			});
		}
		return funcQuery;
	}

	@Override
	public CtFunction getClearFunction() {
		return getFuncClear();
	}

	/**
	 * This method initializes funcClear
	 * 
	 * @return com.classtechnology.base.common.custom.function.BaseUserFunction
	 */
	private BaseUserFunction getFuncClear() {
		if (funcClear == null) {
			funcClear = new BaseUserFunction();
			funcClear.addActionListener(new CtActionListener() {
				@Override
				public void actionPerformed(CtActionEvent arg0) {
					// DeveloperのWHEN-BUTTON-PRESSED TriggerのロジックをCallします。
					procBlkTbClearWhenButtonPressed();
				}
			});
			funcClear.addFunctionListener(new CtFunctionAdapter(){
				@Override
				public void done(CtFunctionSuccessEvent e) {
					super.done(e);
					// 時間更新
					ISZFunctionUtil.setSystemDataTime(lblNowDate);
				}
				
			});
		}
		return funcClear;
	}

	@Override
	public CtFunction getPrintFunction() {
		return getFuncPrint();
	}

	/**
	 * This method initializes funcPrint
	 * 
	 * @return com.classtechnology.base.common.custom.function.BaseUserFunction
	 */
	private BaseUserFunction getFuncPrint() {
		if (funcPrint == null) {
			funcPrint = new BaseUserFunction();
			funcPrint.addActionListener(new CtActionListener() {
				@Override
				public void actionPerformed(CtActionEvent arg0) {
					// DeveloperのWHEN-BUTTON-PRESSED TriggerのロジックをCallします。
					procBlkTbPrintWhenButtonPressed();
				}
			});
			funcPrint.addFunctionListener(new CtFunctionAdapter(){
				@Override
				public void done(CtFunctionSuccessEvent e) {
					super.done(e);
					// 時間更新
					ISZFunctionUtil.setSystemDataTime(lblNowDate);
				}
				
			});
		}
		return funcPrint;
	}


	/**
	 * This method initializes funcSave
	 * 
	 * @return com.classtechnology.base.common.custom.function.BaseUserFunction
	 */
	private BaseUserFunction getFuncSave() {
		if (funcSave == null) {
			funcSave = new BaseUserFunction();
			funcSave.addActionListener(new CtActionListener() {
				@Override
				public void actionPerformed(CtActionEvent arg0) {
					// DeveloperのWHEN-BUTTON-PRESSED TriggerのロジックをCallします。
					procBlkTbSaveWhenButtonPressed();
				}
			});
			funcSave.addFunctionListener(new CtFunctionAdapter(){
				@Override
				public void done(CtFunctionSuccessEvent e) {
					super.done(e);
					// 時間更新
					ISZFunctionUtil.setSystemDataTime(lblNowDate);
				}
				
			});
		}
		return funcSave;
	}

	@Override
	public CtFunction getCancelFunction() {
		return getFuncCancel();
	}

	/**
	 * This method initializes funcCancel
	 * 
	 * @return com.classtechnology.base.common.custom.function.BaseUserFunction
	 */
	private BaseUserFunction getFuncCancel() {
		if (funcCancel == null) {
			funcCancel = new BaseUserFunction();
			funcCancel.addActionListener(new CtActionListener() {
				@Override
				public void actionPerformed(CtActionEvent arg0) {
					// DeveloperのWHEN-BUTTON-PRESSED TriggerのロジックをCallします。
					procBlkTbCancelWhenButtonPressed();
				}
			});
			funcCancel.addFunctionListener(new CtFunctionAdapter(){
				@Override
				public void done(CtFunctionSuccessEvent e) {
					super.done(e);
					// 時間更新
					ISZFunctionUtil.setSystemDataTime(lblNowDate);
				}
				
			});
		}
		return funcCancel;
	}


	/**
	 * This method initializes funcDelete
	 * 
	 * @return com.classtechnology.base.common.custom.function.BaseUserFunction
	 */
	private BaseUserFunction getFuncDelete() {
		if (funcDelete == null) {
			funcDelete = new BaseUserFunction();
			funcDelete.addActionListener(new CtActionListener() {
				@Override
				public void actionPerformed(CtActionEvent arg0) {
					// DeveloperのWHEN-BUTTON-PRESSED TriggerのロジックをCallします。
					procBlkTbDeleteWhenButtonPressed();
				}
			});
			funcDelete.addFunctionListener(new CtFunctionAdapter(){
				@Override
				public void done(CtFunctionSuccessEvent e) {
					super.done(e);
					// 時間更新
					ISZFunctionUtil.setSystemDataTime(lblNowDate);
				}
				
			});
		}
		return funcDelete;
	}



	/**
	 * This method initializes funcInsert
	 * 
	 * @return com.classtechnology.base.common.custom.function.BaseUserFunction
	 */
	private BaseUserFunction getFuncInsert() {
		if (funcInsert == null) {
			funcInsert = new BaseUserFunction();
			funcInsert.addActionListener(new CtActionListener() {
				@Override
				public void actionPerformed(CtActionEvent arg0) {
					// DeveloperのWHEN-BUTTON-PRESSED TriggerのロジックをCallします。
					procBlkTbInsertWhenButtonPressed();
				}
			});
			funcInsert.addFunctionListener(new CtFunctionAdapter(){
				@Override
				public void done(CtFunctionSuccessEvent e) {
					super.done(e);
					// 時間更新
					ISZFunctionUtil.setSystemDataTime(lblNowDate);
				}
				
			});
		}
		return funcInsert;
	}


	/**
	 * This method initializes funcExit
	 * 
	 * @return com.classtechnology.base.common.custom.function.BaseUserFunction
	 */
	private BaseUserFunction getFuncExit() {
		if (funcExit == null) {
			funcExit = new BaseUserFunction();
			funcExit.addActionListener(new CtActionListener() {
				@Override
				public void actionPerformed(CtActionEvent arg0) {
					// DeveloperのWHEN-BUTTON-PRESSED TriggerのロジックをCallします。
					procBlkTbExitWhenButtonPressed();
				}
			});
			funcExit.addFunctionListener(new CtFunctionAdapter(){
				@Override
				public void done(CtFunctionSuccessEvent e) {
					super.done(e);
					// 時間更新
					ISZFunctionUtil.setSystemDataTime(lblNowDate);
				}
				
			});
		}
		return funcExit;
	}

	@Override
	public CtFunction getHelpFunction() {
		return getFuncHelp();
	}

	/**
	 * This method initializes funcHelp
	 * 
	 * @return com.classtechnology.base.common.custom.function.BaseUserFunction
	 */
	private BaseUserFunction getFuncHelp() {
		if (funcHelp == null) {
			funcHelp = new BaseUserFunction();
			funcHelp.addActionListener(new CtActionListener() {
				@Override
				public void actionPerformed(CtActionEvent arg0) {
					// DeveloperのWHEN-BUTTON-PRESSED TriggerのロジックをCallします。
					procBlkTbHelpWhenButtonPressed();
				}
			});
			funcHelp.addFunctionListener(new CtFunctionAdapter(){
				@Override
				public void done(CtFunctionSuccessEvent e) {
					super.done(e);
					// 時間更新
					ISZFunctionUtil.setSystemDataTime(lblNowDate);
				}
				
			});
		}
		return funcHelp;
	}

	/**
	 * procMsjcf31WhenNewFormInstance
	 */
	private void procMsjcf31WhenNewFormInstance() {
		// 時間更新
		ISZFunctionUtil.setSystemDataTime(lblNowDate);
		
		/*----- COMMON PACKAGE VARIABLE SETTING -----*/
		ISZGuiCommonLibMsjlibx.fpjz000X00(getTxtBlkKey1EcrNo(), parParmUserId, getDbcon());
		
		// callPPTZ001X00
		callPPTZ001X00();
		
		/*----- BUTTON ATTRIBUTE CHANGE -----*/
		buttonChange();
		
		// ECSU挿入制御
		getTblMstbecsu().setInsertMode(false);
	}
	
	/**
	 * PPTZ001X00の呼出
	 */
	private void callPPTZ001X00() {
		ISZAppRCAServiceInvoker invoker = new ISZAppRCAServiceInvoker(getDbcon());
		CtAppContainer container = new CtAppContainer();

		try {
			container.setValue("TARGET", "CALL_PPTZ001X00");
			container.setValue("USER_ID", parParmUserId);
			
			CtAppContainer res = invoker.invoke("ecs", "SrvMSJCF31", container);
			
			parParmIemtuser = (String)res.getValue("O_IEMT_STS");
			parParmIemtplant = (String)res.getValue("O_IEMTPLANT");
		} catch (BaseServiceReturnContainerException ex) {

			// BaseServiceReturnContainerExceptionにセットしたContainerを取得
			CtAppContainer responseContainer = ex.getResponseContainer();

			// outputの取得
			String strMessage = BaseStringUtil.nvl(responseContainer.getValue("MSG"));
			CtAppRowSet msgGrpRowSet = responseContainer.getRowSet("MSG_GRP");
			
			// エラーメッセージ処理
			if (msgGrpRowSet != null && msgGrpRowSet.size() > 0) {
				Object msgGrp[] = new Object[msgGrpRowSet.size()];
				for (int i = 0; i < msgGrpRowSet.size(); i++) {
					msgGrp[i] = msgGrpRowSet.getRow(i).getValue("VALUE");
				}
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage, msgGrp);
			} else {
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage);
			}
		} catch (CtAppLogicException ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		} catch (Exception ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		}
	}

	/**
	 * procBlkKey1EcrNoPostTextItem
	 */
	private boolean procBlkKey1EcrNoPostTextItem() {
		int sts = 0;
		String w_after;
		
		if (!getTxtBlkKey1EcrNo().isEditable()) {
			return true;
		}
		
		if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")
				|| ISZFunctionUtil.isFormsEquals(parProcessMode, "QUERY")) {
			if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")) {
				w_after = FpMsjdef.AFTER_ALL;
			} else {
				w_after = FpMsjdef.AFTER_VA;
			}
			
			sts = ISZGuiCommonLibMsjlibx.fcAlpNum(w_after, getTxtBlkKey1EcrNo(), FpMsjdef.CHKMD_FL);
		}
		
		if (sts == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * procBlkKey1RevEcrPostTextItem
	 */
	private boolean procBlkKey1RevEcrPostTextItem() {
		int sts = 0;
		String w_after;
		
		if (!getTxtBlkKey1RevEcr().isEditable()) {
			return true;
		}
		
		if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")
				|| ISZFunctionUtil.isFormsEquals(parProcessMode, "QUERY")) {
			if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")) {
				w_after = FpMsjdef.AFTER_ALL;
			} else {
				w_after = FpMsjdef.AFTER_VA;
			}
			
			sts = ISZGuiCommonLibMsjlibx.fcNum(w_after, getTxtBlkKey1RevEcr(), FpMsjdef.CHKMD_FL);
		}
		
		if (sts == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * procBlkKey1YearPostTextItem
	 */
	private boolean procBlkKey1YearPostTextItem() {
		int sts = 0;
		String w_after;
		
		if (!getTxtBlkKey1Year().isEditable()) {
			return true;
		}
		
		if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")
				|| ISZFunctionUtil.isFormsEquals(parProcessMode, "QUERY")) {
			if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")) {
				w_after = FpMsjdef.AFTER_ALL;
			} else {
				w_after = FpMsjdef.AFTER_VA;
			}
			
			sts = ISZGuiCommonLibMsjlibx.fcNum(w_after, getTxtBlkKey1Year(), FpMsjdef.CHKMD_FL);
			
			if (sts == 0) {
				if (ISZFunctionUtil.isFormsNotEquals(ISZFunctionUtil.orclSubStr((String)getTxtBlkKey1Year().getValue(), 3, 1), "0")
						&& ISZFunctionUtil.isFormsNotEquals(ISZFunctionUtil.orclSubStr((String)getTxtBlkKey1Year().getValue(), 3, 1), "5")) {
	                FpMsjvar.error_msg = ISZFunctionUtil.getMessageById("E-M_INVYEAR");
	                FpMsjvar.error_fld = getTxtBlkKey1Year();
	                FpMsjvar.error_blk = "BLK_KEY1";
	                FpMsjvar.error_rec = "1";
					/* DCR 2013/10/01 START */
	                getTxtBlkKey1Year().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
					/* DCR 2013/10/01 END */
	             //   getTxtBlkKey1Year().setBackground(Color.RED);
	                if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")) {
	                	ISZFunctionUtil.setStatusAreaErrMessage(getTxtBlkKey1Year(), ISZFunctionUtil.getMessageById("E-M_INVYEAR"));
	                	return false;
	                }
				}
			}
		}
		
		if (sts == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * procBlkKey1BookPostTextItem
	 */
	private boolean procBlkKey1BookPostTextItem() {
		int sts = 0;
		String w_after;
		
		if (!getTxtBlkKey1Book().isEditable()) {
			return true;
		}
		
		if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")
				|| ISZFunctionUtil.isFormsEquals(parProcessMode, "QUERY")) {
			if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")) {
				w_after = FpMsjdef.AFTER_ALL;
			} else {
				w_after = FpMsjdef.AFTER_VA;
			}
			if (!BaseStringUtil.isNull(getTxtBlkKey1Year().getValue())) {
				sts = ISZGuiCommonLibMsjlibx.fcAlpNum(w_after, getTxtBlkKey1Book(), FpMsjdef.CHKMD_NIFL);
			} else {
				sts = ISZGuiCommonLibMsjlibx.fcAlpNum(w_after, getTxtBlkKey1Book(), FpMsjdef.CHKMD_FL);
			}
		}
		
		if (sts == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * procBlkKey2EcrNoPostTextItem
	 */
	private boolean procBlkKey2EcrNoPostTextItem() {
		int sts = 0;
		String w_after;
		
		/* DCR 2013/10/01 START */
		if (!getTxtBlkKey2EcrNo().isEditable()) {
			return true;
		}
		/* DCR 2013/10/01 END */
		
		if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")
				|| ISZFunctionUtil.isFormsEquals(parProcessMode, "QUERY")) {
			if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")) {
				w_after = FpMsjdef.AFTER_ALL;
			} else {
				w_after = FpMsjdef.AFTER_VA;
			}
			
			sts = ISZGuiCommonLibMsjlibx.fcAlpNum(w_after, getTxtBlkKey2EcrNo(), FpMsjdef.CHKMD_FL);
		}
		
		if (sts == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * procBlkKey2RevEcrPostTextItem
	 */
	private boolean procBlkKey2RevEcrPostTextItem() {
		int sts = 0;
		String w_after;
		
		/* DCR 2013/10/01 START */
		if (!getTxtBlkKey2RevEcr().isEditable()) {
			return true;
		}
		/* DCR 2013/10/01 END */
		
		if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")
				|| ISZFunctionUtil.isFormsEquals(parProcessMode, "QUERY")) {
			if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")) {
				w_after = FpMsjdef.AFTER_ALL;
			} else {
				w_after = FpMsjdef.AFTER_VA;
			}
			
			sts = ISZGuiCommonLibMsjlibx.fcNum(w_after, getTxtBlkKey2RevEcr(), FpMsjdef.CHKMD_FL);
		}
		
		if (sts == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * procBlkKey2YearPostTextItem
	 */
	private boolean procBlkKey2YearPostTextItem() {
		int sts = 0;
		String w_after;
		
		/* DCR 2013/10/01 START */
		if (!getTxtBlkKey2Year().isEditable()) {
			return true;
		}
		/* DCR 2013/10/01 END */
		
		if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")
				|| ISZFunctionUtil.isFormsEquals(parProcessMode, "QUERY")) {
			if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")) {
				w_after = FpMsjdef.AFTER_ALL;
			} else {
				w_after = FpMsjdef.AFTER_VA;
			}
			
			sts = ISZGuiCommonLibMsjlibx.fcNum(w_after, getTxtBlkKey2Year(), FpMsjdef.CHKMD_FL);
			
			if (sts == 0) {
				if (ISZFunctionUtil.isFormsNotEquals(ISZFunctionUtil.orclSubStr((String)getTxtBlkKey2Year().getValue(), 3, 1), "0")
						&& ISZFunctionUtil.isFormsNotEquals(ISZFunctionUtil.orclSubStr((String)getTxtBlkKey2Year().getValue(), 3, 1), "5")) {
	                FpMsjvar.error_msg = ISZFunctionUtil.getMessageById("E-M_INVYEAR");
	                FpMsjvar.error_fld = getTxtBlkKey2Year();
	                FpMsjvar.error_blk = "BLK_KEY2";
	                FpMsjvar.error_rec = "1";
					/* DCR 2013/10/01 START */
	                getTxtBlkKey2Year().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
					/* DCR 2013/10/01 END */
	                //getTxtBlkKey2Year().setBackground(Color.RED);
	                if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")) {
	                	ISZFunctionUtil.setStatusAreaErrMessage(getTxtBlkKey2Year(), ISZFunctionUtil.getMessageById("E-M_INVYEAR"));
	                	return false;
	                }
				}
			}
		}
		
		if (sts == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * procBlkKey2BookPostTextItem
	 */
	private boolean procBlkKey2BookPostTextItem() {
		int sts = 0;
		String w_after;
		
		/* DCR 2013/10/01 START */
		if (!getTxtBlkKey2Book().isEditable()) {
			return true;
		}
		/* DCR 2013/10/01 END */
		
		if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")
				|| ISZFunctionUtil.isFormsEquals(parProcessMode, "QUERY")) {
			if (ISZFunctionUtil.isFormsEquals(parProcessMode, "NOOP")) {
				w_after = FpMsjdef.AFTER_ALL;
			} else {
				w_after = FpMsjdef.AFTER_VA;
			}
			if (!BaseStringUtil.isNull(getTxtBlkKey2Year().getValue())) {
				sts = ISZGuiCommonLibMsjlibx.fcAlpNum(w_after, getTxtBlkKey2Book(), FpMsjdef.CHKMD_NIFL);
			} else {
				sts = ISZGuiCommonLibMsjlibx.fcAlpNum(w_after, getTxtBlkKey2Book(), FpMsjdef.CHKMD_FL);
			}
		}
		
		if (sts == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * procBlkEcsu1PostQuery
	 */
	private void procBlkEcsu1PostQuery() {
		String w_start_stop = null;
		
		for (int i = 0; i < getTblMstbecsu().getRowCount(); i++) {
			w_start_stop = BaseStringUtil.nvl(getTblMstbecsu().getValueAt(i, "START_STOP_FLG"));
			if (ISZFunctionUtil.isFormsEquals(w_start_stop, "A")) {
				w_start_stop = "-";
			} else if (ISZFunctionUtil.isFormsEquals(w_start_stop, "D")) {
				w_start_stop = "+";
			}
			getTblMstbecsu().setValueAt(w_start_stop, i, "+/-");
		}
		
		// テーブル状態を未編集にする
		getTblMstbecsu().clearStatus();
	}

	/**
	 * procBlkEcsu1PreQuery
	 */
	private void procBlkEcsu1PreQuery() {
		if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("KEY_PTN"), "ADD")) {
			getTblMstbecsu().setDynamicConditionPlugin(getDcmBlkEcsu1Key2());
		} else {
			getTblMstbecsu().setDynamicConditionPlugin(getDcmBlkEcsu1Key1());
		}
	}

	/**
	 * procBlkEcsu1UpcPostTextItem
	 */
	private boolean procBlkEcsu1UpcPostTextItem() {
		int sts = 0;
		String i_upc = null;
		String o_upc = null;

		if (dataCancel) {
			dataCancel = false;
			return true;
		}
		
		sts = ISZGuiCommonLibMsjlibx.fcAlpNum(FpMsjdef.AFTER_ALL, getCcpMstbecsuUpc(), FpMsjdef.CHKMD_NON);
		
		if (sts != 0) {
			delRowFlg = false;
			return false;
		}
		
		if (!BaseStringUtil.isNull(getCcpMstbecsuUpc().getValue())) {
			i_upc = (String)getCcpMstbecsuUpc().getValue();
			
			sts = callPPJZ016X00(i_upc);
			o_upc = (String)ISZOutParameterInfo.instance().get("o_upc");
			
			if (sts != 0) {
				getCcpMstbecsuUpc().setBackground(Color.YELLOW);
				delRowFlg = false;
				return false;
			} else {
				getCcpMstbecsuUpc().setBackground(Color.WHITE);
				ISZGlobalInfo.instance().put("upc", o_upc);
				getCcpMstbecsuUpc().setValue(o_upc);
			}
		}
		
		delRowFlg = true;
		return true;
	}
	
	/**
	 * PPJZ016X00の呼出
	 * @param i_upc
	 * @return out_upc
	 */
	private int callPPJZ016X00(String i_upc) {
		int sts = 0;
		ISZAppRCAServiceInvoker invoker = new ISZAppRCAServiceInvoker(getDbcon());
        CtAppContainer container = new CtAppContainer();
        
        try {
	        container.setValue("TARGET", "CALL_PPJZ016X00");
			container.setValue("USER_ID", parParmUserId);
	        container.setValue("UPC", i_upc);
				
			CtAppContainer res = invoker.invoke("ecs","SrvMSJCF31",container);
	
			ISZOutParameterInfo.instance().put("o_upc", res.getValue("O_UPC"));
			sts = ((BigDecimal) res.getValue("RTN")).intValue();
		} catch (BaseServiceReturnContainerException ex) {

			// BaseServiceReturnContainerExceptionにセットしたContainerを取得
			CtAppContainer responseContainer = ex.getResponseContainer();

			// outputの取得
			String strMessage = BaseStringUtil.nvl(responseContainer.getValue("MSG"));
			CtAppRowSet msgGrpRowSet = responseContainer.getRowSet("MSG_GRP");
			
			// エラーメッセージ処理
			if (msgGrpRowSet != null && msgGrpRowSet.size() > 0) {
				Object msgGrp[] = new Object[msgGrpRowSet.size()];
				for (int i = 0; i < msgGrpRowSet.size(); i++) {
					msgGrp[i] = msgGrpRowSet.getRow(i).getValue("VALUE");
				}
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage, msgGrp);
			} else {
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage);
			}
		} catch (CtAppLogicException ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		} catch (Exception ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		}
		
		return sts;
	}

	/**
	 * procBlkEcsu1UsageCodePostTextItem
	 */
	private boolean procBlkEcsu1UsageCodePostTextItem() {
		
		BaseAutoFilterTableModel filterModel = (BaseAutoFilterTableModel)getTblMstbecsu().getModel();
		BaseResultSetTableModel model = (BaseResultSetTableModel)filterModel.getTableModel();
		model.setTableModelCellStatusToNormalAllCells();
		
		int sts = 0;

		if (dataCancel) {
			dataCancel = false;
			return true;
		}
		
		sts = ISZGuiCommonLibMsjlibx.fcAlpNum(ISZGuiCommonLibMsjlibx.FpMsjdef.AFTER_ALL, getCcpMstbecsuUsageCode(), ISZGuiCommonLibMsjlibx.FpMsjdef.CHKMD_NON);

		if (sts != 0) {
			delRowFlg = false;
			return false;
		}
		
		if (BaseStringUtil.nvl(getCcpMstbecsuUsageCode().getValue()).length() == 4) {
			getCcpMstbecsuUsageCode().setBackground(Color.WHITE);
			model.setTableModelCellStatus(getTblMstbecsu().getSelectedRow(), "Usage", "",BaseTableModelCellStatusControl.CELL_STATUS_NORMAL);
			getCcpMstbecsuUsageCode().setValue(ISZFunctionUtil.orclLPad(getCcpMstbecsuUsageCode().getValue().toString(), 5, " "));
		} else if (BaseStringUtil.nvl(getCcpMstbecsuUsageCode().getValue()).length() == 5) {
		} else {
			/* DCR 2013/10/01 START */
			getCcpMstbecsuUsageCode().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
			/* DCR 2013/10/01 END */
			//getCcpMstbecsuUsageCode().setBackground(Color.RED);
			model.setTableModelCellStatus(getTblMstbecsu().getSelectedRow(), "Usage", "",BaseTableModelCellStatusControl.CELL_STATUS_ERROR);
		}
		
		delRowFlg = true;
		return true;
	}

	/**
	 * procBlkDtle1PreQuery
	 */
	private void procBlkDtle1PreQuery() {
		if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("KEY_PTN"), "ADD")) {
			getTblMstbdtle().setDynamicConditionPlugin(getDcmBlkDtle1Key2());
		} else {
			getTblMstbdtle().setDynamicConditionPlugin(getDcmBlkDtle1Key1());
		}
	}

	/**
	 * procBlkDtle1PostQuery
	 */
	private void procBlkDtle1PostQuery() {
		String w_start_stop = null;
		
		for (int i = 0; i < getTblMstbdtle().getRowCount(); i++) {
			w_start_stop = BaseStringUtil.nvl(getTblMstbdtle().getValueAt(i, "START_STOP_FLG"));
			if (ISZFunctionUtil.isFormsEquals(w_start_stop, "A")) {
				w_start_stop = "-";
			} else if (ISZFunctionUtil.isFormsEquals(w_start_stop, "D")) {
				w_start_stop = "+";
			}
			getTblMstbdtle().setValueAt(w_start_stop, i, "+/-");
		}
		
		// テーブル状態を未編集にする
		getTblMstbdtle().clearStatus();
	}

	/**
	 * procBlkTbQueryWhenButtonPressed
	 */
	private void procBlkTbQueryWhenButtonPressed() {
		String sts = null;
		
		parProcessMode = "QUERY";
		keySave();
		dataCancel();
		keyRestore();
		goBlockBlkKey1();
		sts = keyCheck();
		
		if (ISZFunctionUtil.isFormsEquals(sts, "INV")) {
			// goto実現
			parProcessMode = "NOOP";
			buttonChange();
			return;
		} else if (ISZFunctionUtil.isFormsEquals(sts, "NFF")) {
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "I-CMN-0008");
			/* DCR 2013/10/01 START */
			getTxtBlkKey1EcrNo().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
			getTxtBlkKey1RevEcr().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
			getTxtBlkKey1Year().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
			getTxtBlkKey1Book().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
			/* DCR 2013/10/01 END */			
			/*getTxtBlkKey1EcrNo().setBackground(Color.RED);
			getTxtBlkKey1RevEcr().setBackground(Color.RED);
			getTxtBlkKey1Year().setBackground(Color.RED);
			getTxtBlkKey1Book().setBackground(Color.RED);*/
			// goto実現
			parProcessMode = "NOOP";
			buttonChange();
			return;
		} else if (ISZFunctionUtil.isFormsEquals(sts, "NFT")) {
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "I-CMN-0008");
			getTxtBlkKey2EcrNo().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
			getTxtBlkKey2RevEcr().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
			getTxtBlkKey2Year().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
			getTxtBlkKey2Book().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
			/* DCR 2013/10/01 END */			
			/*
			getTxtBlkKey2EcrNo().setBackground(Color.RED);
			getTxtBlkKey2RevEcr().setBackground(Color.RED);
			getTxtBlkKey2Year().setBackground(Color.RED);
			getTxtBlkKey2Book().setBackground(Color.RED);
			*/
			// goto実現
			parProcessMode = "NOOP";
			buttonChange();
			return;
		} else if (ISZFunctionUtil.isFormsEquals(sts, "SPC")) {
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "E-M_NOUPD");
			/* DCR 2013/10/01 START */
			if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("KEY_PTN"), "DLT")) {
				getTxtBlkKey1EcrNo().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey1RevEcr().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey1Year().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey1Book().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
			} else if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("KEY_PTN"), "ADD")) {
				getTxtBlkKey2EcrNo().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2RevEcr().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2Year().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2Book().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
			} else {
				getTxtBlkKey1EcrNo().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey1RevEcr().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey1Year().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey1Book().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2EcrNo().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2RevEcr().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2Year().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2Book().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
			}
			/* DCR 2013/10/01 END */
			/*
			if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("KEY_PTN"), "DLT")) {
				getTxtBlkKey1EcrNo().setBackground(Color.RED);
				getTxtBlkKey1RevEcr().setBackground(Color.RED);
				getTxtBlkKey1Year().setBackground(Color.RED);
				getTxtBlkKey1Book().setBackground(Color.RED);
			} else if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("KEY_PTN"), "ADD")) {
				getTxtBlkKey2EcrNo().setBackground(Color.RED);
				getTxtBlkKey2RevEcr().setBackground(Color.RED);
				getTxtBlkKey2Year().setBackground(Color.RED);
				getTxtBlkKey2Book().setBackground(Color.RED);
			} else {
				getTxtBlkKey1EcrNo().setBackground(Color.RED);
				getTxtBlkKey1RevEcr().setBackground(Color.RED);
				getTxtBlkKey1Year().setBackground(Color.RED);
				getTxtBlkKey1Book().setBackground(Color.RED);
				getTxtBlkKey2EcrNo().setBackground(Color.RED);
				getTxtBlkKey2RevEcr().setBackground(Color.RED);
				getTxtBlkKey2Year().setBackground(Color.RED);
				getTxtBlkKey2Book().setBackground(Color.RED);
			}
			*/
			// goto実現
			parProcessMode = "NOOP";
			buttonChange();
			return;
		}
		
		if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("DATA_TYPE"), "ECSU")) {
			procBlkEcsu1PreQuery();
			getFuncSearchEcsu().actionPerformed(new ActionEvent(getFuncSearchEcsu(), ActionEvent.ACTION_PERFORMED, getFuncSearchEcsu().getFunctionName()));
			ISZGlobalInfo.instance().put("ECSU_CNT", String.valueOf(getTblMstbecsu().getRowCount()));
			procBlkEcsu1PostQuery();
		} else {
			procBlkDtle1PreQuery();
			getFuncSearchDtle().actionPerformed(new ActionEvent(getFuncSearchDtle(), ActionEvent.ACTION_PERFORMED, getFuncSearchDtle().getFunctionName()));
			ISZGlobalInfo.instance().put("DTLE_CNT", String.valueOf(getTblMstbdtle().getRowCount()));
			procBlkDtle1PostQuery();
		}
		
		parDataMode = "EXIST";
		
		/* DCR 2013/10/01 START */
		getTxtBlkKey1EcrNo().setEditable(false);
		getTxtBlkKey1RevEcr().setEditable(false);
		getTxtBlkKey1Year().setEditable(false);
		getTxtBlkKey1Book().setEditable(false);
		getTxtBlkKey2EcrNo().setEditable(false);
		getTxtBlkKey2RevEcr().setEditable(false);
		getTxtBlkKey2Year().setEditable(false);
		getTxtBlkKey2Book().setEditable(false);
		
		getTxtBlkKey1EcrNo().setBackground(null);
		getTxtBlkKey1RevEcr().setBackground(null);
		getTxtBlkKey1Year().setBackground(null);
		getTxtBlkKey1Book().setBackground(null);
		getTxtBlkKey2EcrNo().setBackground(null);
		getTxtBlkKey2RevEcr().setBackground(null);
		getTxtBlkKey2Year().setBackground(null);
		getTxtBlkKey2Book().setBackground(null);

		/* DCR 2013/10/01 END
		getTxtBlkKey1EcrNo().setEnabled(false);
		getTxtBlkKey1RevEcr().setEnabled(false);
		getTxtBlkKey1Year().setEnabled(false);
		getTxtBlkKey1Book().setEnabled(false);
		getTxtBlkKey2EcrNo().setEnabled(false);
		getTxtBlkKey2RevEcr().setEnabled(false);
		getTxtBlkKey2Year().setEnabled(false);
		getTxtBlkKey2Book().setEnabled(false);
		*/
		
		parProcessMode = "NOOP";
		buttonChange();
	}

	/**
	 * procBlkTbClearWhenButtonPressed
	 */
	private void procBlkTbClearWhenButtonPressed() {

		dataCancel = true;
		Toolkit.getDefaultToolkit().beep();
	    keySave();
	    dataCancel();
	    keyRestore();
	    goBlockBlkKey1();
	    
	    /* DCR 2013/10/01 START */
		getTxtBlkKey2EcrNo().setEditable(true);
		getTxtBlkKey2RevEcr().setEditable(true);
		getTxtBlkKey2Year().setEditable(true);
		getTxtBlkKey2Book().setEditable(true);
		
		getTxtBlkKey2EcrNo().setBackground(Color.white);
		getTxtBlkKey2RevEcr().setBackground(Color.white);
		getTxtBlkKey2Year().setBackground(Color.white);
		getTxtBlkKey2Book().setBackground(Color.white);
	    
		/* DCR 2013/10/01 END
		getTxtBlkKey2EcrNo().setEnabled(true);
		getTxtBlkKey2RevEcr().setEnabled(true);
		getTxtBlkKey2Year().setEnabled(true);
		getTxtBlkKey2Book().setEnabled(true);
		*/
	}

	/**
	 * procBlkTbPrintWhenButtonPressed
	 */
	private void procBlkTbPrintWhenButtonPressed() {
		
		parProcessMode = "PRINT";
		CtCustomUtil.captureTopContainer(funcPrint.getOwnerContainer());
		parProcessMode = "NOOP";
		buttonChange();
	}

	/**
	 * procBlkTbSaveWhenButtonPressed
	 */
	private void procBlkTbSaveWhenButtonPressed() {
		int sts = 0;
		String ecsc_sts1 = null;
		String ecsc_sts2 = null;
		String alt_msg = null;
		String dlt_msg = "Q-MSJCF31-5";
		String add_msg = "Q-MSJCF31-6";
		String pointer_msg = "E-MSJCF31-7";
		
		getTblMstbecsu().stopCellEditing();
		getTblMstbdtle().stopCellEditing();
		
		if (ISZFunctionUtil.isFormsEquals(parProcessMode, "INSERT")) {
			if (!BaseStringUtil.isNull(getTxtBlkKey2EcrNo().getValue())
			 && !BaseStringUtil.isNull(getTxtBlkKey2RevEcr().getValue())
			 && !BaseStringUtil.isNull(getTxtBlkKey2Year().getValue())
			 && !BaseStringUtil.isNull(getTxtBlkKey2Book().getValue())) {
				
				/* DCR 2014/03/28 START */
				getTxtBlkKey2EcrNo().setBackground(BaseValidatorConstant.VALIDATION_NORMAL_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2RevEcr().setBackground(BaseValidatorConstant.VALIDATION_NORMAL_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2Year().setBackground(BaseValidatorConstant.VALIDATION_NORMAL_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2Book().setBackground(BaseValidatorConstant.VALIDATION_NORMAL_COMPONENT_BACKGROUND_COLOR);
				/* DCR 2014/03/28 END */
				
				sts = insertProc();
				if (sts == 0) {
					if (BaseStringUtil.nvl(getTxtBlkCtrlUpdCnt().getValue()).compareTo("0") > 0) {
						getTblMstbecsu().clearStatus();
						getTblMstbdtle().clearStatus();
						BaseMessageIndicator.indicate(getTxtBlkKey2EcrNo(), "I-M_KANRYOU", new Object[] {getTxtBlkCtrlUpdCnt().getValue()});
					}
				} else {
					// goto end1
					return;
				}
			} else {
				
				getTxtBlkKey2EcrNo().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2RevEcr().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2Year().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2Book().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				/* DCR 2013/10/01 START */
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "E-ISNOTNULL");
				getTxtBlkKey2EcrNo().requestFocus();
				/* DCR 2013/10/01 END */
				/*
				getTxtBlkKey2EcrNo().setBackground(Color.RED);
				getTxtBlkKey2RevEcr().setBackground(Color.RED);
				getTxtBlkKey2Year().setBackground(Color.RED);
				getTxtBlkKey2Book().setBackground(Color.RED);
				*/
			}
			// goto end1
			return;
		} else {
			if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("KEY_PTN"), "DLT")) {
				ecsc_sts1 = ecscCheck((String)getTxtBlkKey1EcrNo().getValue()
									, (String)getTxtBlkKey1RevEcr().getValue()
									, (String)getTxtBlkKey1Year().getValue()
									, (String)getTxtBlkKey1Book().getValue()
									, "  ");
				if (ISZFunctionUtil.isFormsEquals(ecsc_sts1, "1")) {
					parParmIemt = "1";
				} else {
					parParmIemt = "0";
				}
			} else if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("KEY_PTN"), "ADD")) {
				ecsc_sts2 = ecscCheck((String)getTxtBlkKey2EcrNo().getValue()
									, (String)getTxtBlkKey2RevEcr().getValue()
									, (String)getTxtBlkKey2Year().getValue()
									, (String)getTxtBlkKey2Book().getValue()
									, "  ");
				if (ISZFunctionUtil.isFormsEquals(ecsc_sts2, "1")) {
					parParmIemt = "1";
				} else {
					parParmIemt = "0";
				}
			} else {
				ecsc_sts1 = ecscCheck((String)getTxtBlkKey1EcrNo().getValue()
									, (String)getTxtBlkKey1RevEcr().getValue()
									, (String)getTxtBlkKey1Year().getValue()
									, (String)getTxtBlkKey1Book().getValue()
									, "  ");
				ecsc_sts2 = ecscCheck((String)getTxtBlkKey2EcrNo().getValue()
									, (String)getTxtBlkKey2RevEcr().getValue()
									, (String)getTxtBlkKey2Year().getValue()
									, (String)getTxtBlkKey2Book().getValue()
									, "  ");
				if (ISZFunctionUtil.isFormsEquals(ecsc_sts1, "1")
				 && ISZFunctionUtil.isFormsEquals(ecsc_sts2, "1")) {
					parParmIemt = "1";
				} else {
					parParmIemt = "0";
				}
			}
			
			if (ISZFunctionUtil.isFormsEquals(parParmIemtuser, "1")
			 && ISZFunctionUtil.isFormsEquals(parParmIemt, "0")) {
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "E-M_ISZTUPDATE");
				// GOTO err;
				parProcessMode = "NOOP";
			    buttonChange();
			    return;
			}
			
			if (ISZFunctionUtil.isFormsEquals(parParmIemtuser, "0")
			 && ISZFunctionUtil.isFormsEquals(parParmIemt, "1")) {
				if (!BaseMessageIndicator.confirm(getTxtBlkKey1EcrNo(), "Q-M_COMMON", new Object[]{ISZFunctionUtil.getMessageById("E-A_IEMTUPDATE")})) {
					// NOを選択した場合
					// GOTO err;
					parProcessMode = "NOOP";
				    buttonChange();
				    return;
				}
			}
			
			if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("DATA_TYPE"), "ECSU")) {
				if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("KEY_PTN"), "DLT")) {
					alt_msg = dlt_msg;
				} else {
					alt_msg = add_msg;
				}
			} else {
				alt_msg = add_msg;
			}
			
			if (!BaseMessageIndicator.confirm(getTxtBlkKey1EcrNo(), "Q-M_COMMON", new Object[]{alt_msg})) {
				// NOを選択した場合
				// GOTO end1;
				return;
			} else {
				// OK選択した場合
				parProcessMode = "SAVE";
				getTxtBlkCtrlUpdCnt().setValue("0");
				if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("KEY_PTN"), "DLT")) {
					sts = delProc();
					if (sts == -2) {
						BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), pointer_msg);
						// GOTO err;
						parProcessMode = "NOOP";
					    buttonChange();
					    return;
					}
					if (sts != 0) {
						/* 2014/03/27 DCR START */ 
						BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "E-M_DBERRMSG2");
						/* 2014/03/27 DCR END */ 
						// GOTO err;
						parProcessMode = "NOOP";
					    buttonChange();
					    return;
					}
				} else if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("KEY_PTN"), "ADD")) {
					sts = addProc();
					if (sts == 1) {
						BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "E-M_DUPL10");
						// GOTO err;
						parProcessMode = "NOOP";
					    buttonChange();
					    return;
					} else if (sts == -1) {
						/* 2014/03/27 DCR START */ 
						BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "E-M_DBERRMSG2");
						/* 2014/03/27 DCR END */ 
						// GOTO err;
						parProcessMode = "NOOP";
					    buttonChange();
					    return;
					}
				} else {
					sts = trnProc();
					if (sts == -2) {
						BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), pointer_msg);
						// GOTO err;
						parProcessMode = "NOOP";
					    buttonChange();
					    return;
					} else if (sts == 1) {
						BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "E-M_DUPL10");
						// GOTO err;
						parProcessMode = "NOOP";
					    buttonChange();
					    return;
					} else if (sts == -1) {
						/* 2014/03/27 DCR START */ 
						BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "E-M_DBERRMSG2");
						/* 2014/03/27 DCR END */ 

						// GOTO err;
						parProcessMode = "NOOP";
					    buttonChange();
					    return;
					}
				}
				
				// commitがあるから、下記のDB処理を分けています.
				
				if (((String)getTxtBlkCtrlUpdCnt().getValue()).compareTo("0") > 0) {
					BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "I-M_KANRYOU", new Object[]{getTxtBlkCtrlUpdCnt().getValue()});
					BaseAccessLogger.log(AccessType.SAVE_ACTION, "FrmMSJCF31");
				}

				if (!BaseStringUtil.isNull(getTxtBlkKey1EcrNo().getValue())
				 && !BaseStringUtil.isNull(getTxtBlkKey1Year().getValue())
				 && !BaseStringUtil.isNull(getTxtBlkKey1Book().getValue())
				 && ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("KEY_PTN"), "DLT")
				 && ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("DATA_TYPE"), "ECSU")) {
					
					sts = usageDel();
					
					if (sts == -1) {
						BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "E-M_DUPL10");
						// GOTO err;
						parProcessMode = "NOOP";
					    buttonChange();
					    return;
					}
				} else {
					/* 2014/03/27 DCR START */ 
					if (((String)getTxtBlkCtrlUpdCnt().getValue()).compareTo("0") > 0) {
						getTblMstbecsu().clearStatus();
						getTblMstbdtle().clearStatus();
					}
					/* 2014/03/27 DCR END */ 
				}
			}
		}
	}

	/**
	 * procBlkTbCancelWhenButtonPressed
	 */
	private void procBlkTbCancelWhenButtonPressed() {
		
		getTblMstbecsu().setInsertMode(false);

		dataCancel = true;
		parProcessMode = "CANCEL";
		dataCancel();
		parProcessMode = "NOOP";
		buttonChange();

		getTxtBlkKey1EcrNo().setEditable(true);
		getTxtBlkKey1RevEcr().setEditable(true);
		getTxtBlkKey1Year().setEditable(true);
		getTxtBlkKey1Book().setEditable(true);		

		getTxtBlkKey1EcrNo().setBackground(Color.WHITE);
		getTxtBlkKey1RevEcr().setBackground(Color.WHITE);
		getTxtBlkKey1Year().setBackground(Color.WHITE);
		getTxtBlkKey1Book().setBackground(Color.WHITE);
		getTxtBlkKey2EcrNo().setBackground(Color.WHITE);
		getTxtBlkKey2RevEcr().setBackground(Color.WHITE);
		getTxtBlkKey2Year().setBackground(Color.WHITE);
		getTxtBlkKey2Book().setBackground(Color.WHITE);
			
		tblMstbecsu.setColumnAccessSetting(new com.classtechnology.custom.gui.CtTableColumnAccessSetting(new java.lang.Object[][] {
				new java.lang.Object[] { com.classtechnology.custom.gui.CtTableColumnAccessSetting.PROP_EDITABLE_COLUMNS, new java.lang.String[] { "INTENT" } },
				new java.lang.Object[] { com.classtechnology.custom.gui.CtTableColumnAccessSetting.PROP_DISPLAY_COLUMNS, new java.lang.String[] { "+/-", "Part", "Upc", "Fna", "Usage", "Qty", "INTENT", "Message" } },
				new java.lang.Object[] { com.classtechnology.custom.gui.CtTableColumnAccessSetting.PROP_VISIBLE_COLUMNS, new java.lang.String[] { "+/-", "Part", "Upc", "Fna", "Usage", "Qty", "INTENT", "Message" } }
			}));
		
		getFuncSave().setEnabled(false);
		getFuncQuery().setEnabled(true);
		getFuncDelete().setEnabled(false);
		
		goBlockBlkKey1();
	}

	/**
	 * procBlkTbDeleteWhenButtonPressed
	 */
	private void procBlkTbDeleteWhenButtonPressed() {
		int row = -1;
		int col = -1;
		
		getTblMstbecsu().stopCellEditing();
		getTblMstbdtle().stopCellEditing();
		
		if (BaseMessageIndicator.confirm(getTxtBlkKey1EcrNo(), "Q-DEL_YES_NO") && delRowFlg) {
			row = getTblMstbecsu().getSelectedRow();
			col = getTblMstbecsu().getSelectedColumn();
			
			getFuncDeleteEcsu().actionPerformed(new ActionEvent(getFuncDeleteEcsu(), ActionEvent.ACTION_PERFORMED, getFuncDeleteEcsu().getFunctionName()));

			
			if (getTblMstbecsu().getRowCount() < 1) {
				if (getTblMstbecsu().isInsertMode()) {
					getFuncInsertEcsu().actionPerformed(new ActionEvent(getFuncInsertEcsu(), ActionEvent.ACTION_PERFORMED, getFuncInsertEcsu().getFunctionName()));
					getTblMstbecsu().setRowSelectionInterval(0, 0);
					getTblMstbecsu().setColumnSelectionInterval(0, 0);
					getTblMstbecsu().changeSelection(0, 0, true, true);
				}
			} else {
				if (row > getTblMstbecsu().getRowCount() - 1) {
					row = getTblMstbecsu().getRowCount() - 1;
				}
				getTblMstbecsu().setRowSelectionInterval(row, row);
				getTblMstbecsu().setColumnSelectionInterval(col, col);
				getTblMstbecsu().changeSelection(row, col, true, true);
			}
		}
	}

	/**
	 * procBlkTbInsertWhenButtonPressed
	 */
	private void procBlkTbInsertWhenButtonPressed() {
		
		parProcessMode = "INSERT";
		
		getTblMstbecsu().setColumnAccessSetting(new com.classtechnology.custom.gui.CtTableColumnAccessSetting(new java.lang.Object[][] {
				new java.lang.Object[] { com.classtechnology.custom.gui.CtTableColumnAccessSetting.PROP_EDITABLE_COLUMNS, new java.lang.String[] { "+/-", "Part", "Upc", "Fna", "Usage", "Qty", "INTENT" } },
				new java.lang.Object[] { com.classtechnology.custom.gui.CtTableColumnAccessSetting.PROP_DISPLAY_COLUMNS, new java.lang.String[] { "+/-", "Part", "Upc", "Fna", "Usage", "Qty", "INTENT", "Message" } },
				new java.lang.Object[] { com.classtechnology.custom.gui.CtTableColumnAccessSetting.PROP_VISIBLE_COLUMNS, new java.lang.String[] { "+/-", "Part", "Upc", "Fna", "Usage", "Qty", "INTENT", "Message" } }
			}));
		
		getTblMstbecsu().setInsertMode(true);
		dataCancel();

		getTxtBlkKey1EcrNo().setEditable(false);
		getTxtBlkKey1RevEcr().setEditable(false);
		getTxtBlkKey1Year().setEditable(false);
		getTxtBlkKey1Book().setEditable(false);

		getFuncSave().setEnabled(true);
		getFuncQuery().setEnabled(false);
		getFuncDelete().setEnabled(true);
		
		goBlockBlkKey1();
	}

	/**
	 * procBlkTbExitWhenButtonPressed
	 */
	private void procBlkTbExitWhenButtonPressed() {
		parProcessMode = "EXIT";
		FrmMSJCF31.this.dispose();
		parProcessMode = "NOOP";
	}

	/**
	 * procBlkTbHelpWhenButtonPressed
	 */
	private void procBlkTbHelpWhenButtonPressed() {

	}

	/**
	 * delProc
	 */
	private int delProc() {
		int rtn = 0;
		
		ISZAppRCAServiceInvoker invoker = new ISZAppRCAServiceInvoker(getDbcon());

		try {
			CtAppContainer res = invoker.invoke("ecs", "SrvMSJCF31", makeContainer("DEL_PROC"));
			
			rtn = ((BigDecimal)res.getValue("RTN")).intValue();
			// メッセージセット
			CtAppRowSet ecsuRowSet = res.getRowSet("BLK_ECSU1_REP");
			CtAppRowSet dtleRowSet = res.getRowSet("BLK_DTLE1_REP");
			if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("DATA_TYPE"), "ECSU")) {
				for (int i = 0; i < ecsuRowSet.size(); i++) {
					/* 2014/03/20 DCR START */
					if (BaseStringUtil.isNull(getTblMstbecsu().getValueAt(i, "Message"))) {
					/* 2014/03/20 DCR END */
						getTblMstbecsu().setValueAt(ecsuRowSet.getRow(i).getValue("BLK_ECSU1_ECSU_MESSAGE"), i, "Message");
					}
				}
			} else {
				for (int i = 0; i < dtleRowSet.size(); i++) {
					/* 2014/03/20 DCR START */
					if (BaseStringUtil.isNull(getTblMstbdtle().getValueAt(i, "Message"))) {
					/* 2014/03/20 DCR END */
						getTblMstbdtle().setValueAt(dtleRowSet.getRow(i).getValue("BLK_DTLE1_DTLE_MESSAGE"), i, "Message");
					}
				}
			}

			if (rtn == 0) {
				// 件数更新
				getTxtBlkCtrlUpdCnt().setValue(res.getValue("BLK_CTRL_UPD_CNT"));
			}
		} catch (BaseServiceReturnContainerException ex) {

			// BaseServiceReturnContainerExceptionにセットしたContainerを取得
			CtAppContainer responseContainer = ex.getResponseContainer();

			// outputの取得
			String strMessage = BaseStringUtil.nvl(responseContainer.getValue("MSG"));
			CtAppRowSet msgGrpRowSet = responseContainer.getRowSet("MSG_GRP");
			
			// エラーメッセージ処理
			if (msgGrpRowSet != null && msgGrpRowSet.size() > 0) {
				Object msgGrp[] = new Object[msgGrpRowSet.size()];
				for (int i = 0; i < msgGrpRowSet.size(); i++) {
					msgGrp[i] = msgGrpRowSet.getRow(i).getValue("VALUE");
				}
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage, msgGrp);
			} else {
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage);
			}
		} catch (CtAppLogicException ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		} catch (Exception ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		}
		
		return rtn;
	}

	/**
	 * addProc
	 */
	private int addProc() {
		int rtn = 0;
		
		ISZAppRCAServiceInvoker invoker = new ISZAppRCAServiceInvoker(getDbcon());

		try {
			CtAppContainer res = invoker.invoke("ecs", "SrvMSJCF31", makeContainer("ADD_PROC"));
			
			rtn = ((BigDecimal)res.getValue("RTN")).intValue();
			
			// メッセージセット
			CtAppRowSet ecsuRowSet = res.getRowSet("BLK_ECSU1_REP");
			CtAppRowSet dtleRowSet = res.getRowSet("BLK_DTLE1_REP");
			if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("DATA_TYPE"), "ECSU")) {
				for (int i = 0; i < ecsuRowSet.size(); i++) {
					/* 2014/03/20 DCR START */
					if (BaseStringUtil.isNull(getTblMstbecsu().getValueAt(i, "Message"))) {
					/* 2014/03/20 DCR END */
						getTblMstbecsu().setValueAt(ecsuRowSet.getRow(i).getValue("BLK_ECSU1_INTENT"), i, "INTENT");
						getTblMstbecsu().setValueAt(ecsuRowSet.getRow(i).getValue("BLK_ECSU1_ECSU_MESSAGE"), i, "Message");
					}
				}
			} else {
				for (int i = 0; i < dtleRowSet.size(); i++) {
					/* 2014/03/20 DCR START */
					if (BaseStringUtil.isNull(getTblMstbdtle().getValueAt(i, "Message"))) {
					/* 2014/03/20 DCR END */
						getTblMstbdtle().setValueAt(dtleRowSet.getRow(i).getValue("BLK_DTLE1_INTENT"), i, "INTENT");
						getTblMstbdtle().setValueAt(dtleRowSet.getRow(i).getValue("BLK_DTLE1_DTLE_MESSAGE"), i, "Message");
					}
				}
			}

			if (rtn == 0) {
				// 件数更新
				getTxtBlkCtrlUpdCnt().setValue(res.getValue("BLK_CTRL_UPD_CNT"));
			}
		} catch (BaseServiceReturnContainerException ex) {

			// BaseServiceReturnContainerExceptionにセットしたContainerを取得
			CtAppContainer responseContainer = ex.getResponseContainer();

			// outputの取得
			String strMessage = BaseStringUtil.nvl(responseContainer.getValue("MSG"));
			CtAppRowSet msgGrpRowSet = responseContainer.getRowSet("MSG_GRP");
			
			// エラーメッセージ処理
			if (msgGrpRowSet != null && msgGrpRowSet.size() > 0) {
				Object msgGrp[] = new Object[msgGrpRowSet.size()];
				for (int i = 0; i < msgGrpRowSet.size(); i++) {
					msgGrp[i] = msgGrpRowSet.getRow(i).getValue("VALUE");
				}
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage, msgGrp);
			} else {
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage);
			}
		} catch (CtAppLogicException ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		} catch (Exception ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		}
		
		return rtn;
	}

	/**
	 * trnProc
	 */
	private int trnProc() {
		int rtn = 0;
		
		ISZAppRCAServiceInvoker invoker = new ISZAppRCAServiceInvoker(getDbcon());

		try {
			CtAppContainer res = invoker.invoke("ecs", "SrvMSJCF31", makeContainer("TRN_PROC"));
			
			rtn = ((BigDecimal)res.getValue("RTN")).intValue();

			// メッセージセット
			CtAppRowSet ecsuRowSet = res.getRowSet("BLK_ECSU1_REP");
			CtAppRowSet dtleRowSet = res.getRowSet("BLK_DTLE1_REP");
			if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("DATA_TYPE"), "ECSU")) {
				for (int i = 0; i < ecsuRowSet.size(); i++) {
					/* 2014/03/20 DCR START */
					if (BaseStringUtil.isNull(getTblMstbecsu().getValueAt(i, "Message"))) {
					/* 2014/03/20 DCR END */
						getTblMstbecsu().setValueAt(ecsuRowSet.getRow(i).getValue("BLK_ECSU1_ECSU_MESSAGE"), i, "Message");
					}
				}
			} else {
				for (int i = 0; i < dtleRowSet.size(); i++) {
					/* 2014/03/20 DCR START */
					if (BaseStringUtil.isNull(getTblMstbdtle().getValueAt(i, "Message"))) {
					/* 2014/03/20 DCR END */
						getTblMstbdtle().setValueAt(dtleRowSet.getRow(i).getValue("BLK_DTLE1_DTLE_MESSAGE"), i, "Message");
					}
				}
			}

			if (rtn == 0) {
				// 件数更新
				getTxtBlkCtrlUpdCnt().setValue(res.getValue("BLK_CTRL_UPD_CNT"));
			}
		} catch (BaseServiceReturnContainerException ex) {

			// BaseServiceReturnContainerExceptionにセットしたContainerを取得
			CtAppContainer responseContainer = ex.getResponseContainer();

			// outputの取得
			String strMessage = BaseStringUtil.nvl(responseContainer.getValue("MSG"));
			CtAppRowSet msgGrpRowSet = responseContainer.getRowSet("MSG_GRP");
			
			// エラーメッセージ処理
			if (msgGrpRowSet != null && msgGrpRowSet.size() > 0) {
				Object msgGrp[] = new Object[msgGrpRowSet.size()];
				for (int i = 0; i < msgGrpRowSet.size(); i++) {
					msgGrp[i] = msgGrpRowSet.getRow(i).getValue("VALUE");
				}
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage, msgGrp);
			} else {
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage);
			}
		} catch (CtAppLogicException ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		} catch (Exception ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		}
		
		return rtn;
	}

	/**
	 * buttonChange
	 */
	private void buttonChange() {
		/*----- BUTTON ATTRIBUTE CHANGE -----*/
		getFuncQuery().setEnabled(true);
		getFuncClear().setEnabled(true);
		getFuncPrint().setEnabled(true);
		getFuncCancel().setEnabled(true);
		getFuncExit().setEnabled(true);
		getFuncHelp().setEnabled(true);
		getFuncDelete().setEnabled(false);
		if (ISZFunctionUtil.isFormsEquals(parDataMode, "NODATA")) {
			getFuncSave().setEnabled(false);
		} else {
			getFuncSave().setEnabled(true);
		}
	}

	/**
	 * dataCancel
	 */
	private void dataCancel() {

		/* DCR 2013/10/01 START */
		if (!getTxtBlkKey2EcrNo().isEditable()) {

			getTxtBlkKey2EcrNo().setEditable(true);
			getTxtBlkKey2RevEcr().setEditable(true);
			getTxtBlkKey2Year().setEditable(true);
			getTxtBlkKey2Book().setEditable(true);
			
			getTxtBlkKey2EcrNo().setBackground(Color.white);
			getTxtBlkKey2RevEcr().setBackground(Color.white);
			getTxtBlkKey2Year().setBackground(Color.white);
			getTxtBlkKey2Book().setBackground(Color.white);

			/* DCR 2013/10/01 END
		if (!getTxtBlkKey2EcrNo().isEnabled()()) {
			getTxtBlkKey2EcrNo().setEnabled(true);
			getTxtBlkKey2RevEcr().setEnabled(true);
			getTxtBlkKey2Year().setEnabled(true);
			getTxtBlkKey2Book().setEnabled(true);
			 */
		}
		
		if (!getTxtBlkKey1EcrNo().isEditable()) {
			
			/* DCR 2013/10/01 START */
			getTxtBlkKey1EcrNo().setEditable(true);
			getTxtBlkKey1RevEcr().setEditable(true);
			getTxtBlkKey1Year().setEditable(true);
			getTxtBlkKey1Book().setEditable(true);
			
			getTxtBlkKey1EcrNo().setBackground(Color.white);
			getTxtBlkKey1RevEcr().setBackground(Color.white);
			getTxtBlkKey1Year().setBackground(Color.white);
			getTxtBlkKey1Book().setBackground(Color.white);

		/* DCR 2013/10/01 END
		if (!getTxtBlkKey1EcrNo().isEnabled()) {

			getTxtBlkKey1EcrNo().setEnabled(true);
			getTxtBlkKey1RevEcr().setEnabled(true);
			getTxtBlkKey1Year().setEnabled(true);
			getTxtBlkKey1Book().setEnabled(true);
			*/
		}

		getTxtBlkKey1EcrNo().setValue(null);
		getTxtBlkKey1RevEcr().setValue(null);
		getTxtBlkKey1Year().setValue(null);
		getTxtBlkKey1Book().setValue(null);
		getTxtBlkKey2EcrNo().setValue(null);
		getTxtBlkKey2RevEcr().setValue(null);
		getTxtBlkKey2Year().setValue(null);
		getTxtBlkKey2Book().setValue(null);
		if (ISZFunctionUtil.isFormsNotEquals(parProcessMode, "INSERT")) {
			getTxtBlkKey1EcrNo().setBackground(Color.WHITE);
			getTxtBlkKey1RevEcr().setBackground(Color.WHITE);
			getTxtBlkKey1Year().setBackground(Color.WHITE);
			getTxtBlkKey1Book().setBackground(Color.WHITE);
		} else {
			getTxtBlkKey1EcrNo().setBackground(null);
			getTxtBlkKey1RevEcr().setBackground(null);
			getTxtBlkKey1Year().setBackground(null);
			getTxtBlkKey1Book().setBackground(null);
		}
		getTxtBlkKey2EcrNo().setBackground(Color.WHITE);
		getTxtBlkKey2RevEcr().setBackground(Color.WHITE);
		getTxtBlkKey2Year().setBackground(Color.WHITE);
		getTxtBlkKey2Book().setBackground(Color.WHITE);

		getTblMstbecsu().stopCellEditing();
		delRowFlg = true;
		getTblMstbecsu().clear();
		getTblMstbecsu().clearStatus();
		getTblMstbdtle().clear();
		getTblMstbdtle().clearStatus();
		if (getTblMstbecsu().isInsertMode()) {
			getFuncInsertEcsu().actionPerformed(new ActionEvent(getFuncInsertEcsu(), ActionEvent.ACTION_PERFORMED, getFuncInsertEcsu().getFunctionName()));
			getTblMstbecsu().setRowSelectionInterval(0, 0);
			getTblMstbecsu().setColumnSelectionInterval(0, 0);
			getTblMstbecsu().changeSelection(0, 0, true, true);
		}

		parDataMode = "NODATA";
	}

	/**
	 * keyCheck
	 * RETURN CODE
	 * 'NFF' = NO DATA FOUND(FROM)
	 * 'NFT' = NO DATA FOUND(TO)
	 * 'ERR' = DB ERROR
	 * 'SPC' = ECS DATA BEFORE START
	 *       OR ECS DATA COMPLETED
	 * 'FIN' = NORMAL PROCESSED
	 */
	private String keyCheck() {
		String strRtn = "";
		
		FpMsjvar.error_msg = null;
	    /*------------------------------*/
	    /*  BLK_KEY2 INPUT VALUE CHECK  */
	    /*------------------------------*/
		procBlkKey2BookPostTextItem();
		procBlkKey2YearPostTextItem();
		procBlkKey2RevEcrPostTextItem();
		procBlkKey2EcrNoPostTextItem();

	    /*------------------------------*/
	    /*  BLK_KEY1 INPUT VALUE CHECK  */
	    /*------------------------------*/
		procBlkKey1BookPostTextItem();
		procBlkKey1YearPostTextItem();
		procBlkKey1RevEcrPostTextItem();
		procBlkKey1EcrNoPostTextItem();
		
		if (!BaseStringUtil.isNull(FpMsjvar.error_msg)) {
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "E-M_COMMON", new Object[] {FpMsjvar.error_msg});
			if (FpMsjvar.error_fld != null && FpMsjvar.error_fld instanceof BaseTextField) {
				((BaseTextField)FpMsjvar.error_fld).requestFocus();
			}
			return "INV";
		}

	    /*---------------------------------------*/
	    /*  BLK_KEY1 and BLK_KEY2 FUKUGOU CHECK  */
	    /*---------------------------------------*/
		if (!BaseStringUtil.isNull(getTxtBlkKey1EcrNo().getValue())
		 && !BaseStringUtil.isNull(getTxtBlkKey2EcrNo().getValue())) {
			if (ISZFunctionUtil.isFormsNotEquals(ISZFunctionUtil.orclNvl(getTxtBlkKey1Year().getValue(), " ")
												, ISZFunctionUtil.orclNvl(getTxtBlkKey2Year().getValue(), " "))
			 || ISZFunctionUtil.isFormsNotEquals(ISZFunctionUtil.orclNvl(getTxtBlkKey1Book().getValue(), " ")
												, ISZFunctionUtil.orclNvl(getTxtBlkKey2Book().getValue(), " "))
			 || (ISZFunctionUtil.isFormsEquals(ISZFunctionUtil.orclNvl(getTxtBlkKey2RevEcr().getValue(), " "), " ")
			  || ISZFunctionUtil.isFormsEquals(ISZFunctionUtil.orclNvl(getTxtBlkKey2RevEcr().getValue(), " "), "0"))
			 || ISZFunctionUtil.isFormsEquals(ISZFunctionUtil.orclNvl(getTxtBlkKey1EcrNo().getValue(), " "), " ")
			 || ISZFunctionUtil.isFormsEquals(ISZFunctionUtil.orclNvl(getTxtBlkKey2EcrNo().getValue(), " "), " ")) {
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "E-M_NOCHG");
				goBlockBlkKey2();
				/* DCR 2013/10/01 START */
				getTxtBlkKey2EcrNo().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2RevEcr().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2Year().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2Book().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				/* DCR 2013/10/01 END */
				//getTxtBlkKey2EcrNo().setBackground(Color.RED);
				//getTxtBlkKey2RevEcr().setBackground(Color.RED);
				//getTxtBlkKey2Year().setBackground(Color.RED);
				//getTxtBlkKey2Book().setBackground(Color.RED);
				
				return "INV";
			}
			
			if (!BaseStringUtil.isNull(getTxtBlkKey1EcrNo().getValue())
			 && !BaseStringUtil.isNull(getTxtBlkKey2EcrNo().getValue())
			 && BaseStringUtil.isNull(getTxtBlkKey1Book().getValue())
			 && BaseStringUtil.isNull(getTxtBlkKey2Book().getValue())) {
				if (ISZFunctionUtil.isFormsNotEquals((String)getTxtBlkKey1EcrNo().getValue(), (String)getTxtBlkKey2EcrNo().getValue())) {
					BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "E-MSJCF31-0");
					/* DCR 2013/10/01 START */
					getTxtBlkKey1EcrNo().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
					getTxtBlkKey2EcrNo().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
					/* DCR 2013/10/01 END */
					//getTxtBlkKey1EcrNo().setBackground(Color.RED);
					//getTxtBlkKey2EcrNo().setBackground(Color.RED);
					return "INV";
				}
			}
		}
		
		// 既存のbreak　？

		/*---- KEY PATURN HANDLING ----*/
		if (!BaseStringUtil.isNull(getTxtBlkKey1EcrNo().getValue())) {
			if (!BaseStringUtil.isNull(getTxtBlkKey2EcrNo().getValue())) {
				ISZGlobalInfo.instance().put("KEY_PTN", "TRN");
			} else {
				ISZGlobalInfo.instance().put("KEY_PTN", "DLT");
			}
		} else {
			if (!BaseStringUtil.isNull(getTxtBlkKey2EcrNo().getValue())) {
				ISZGlobalInfo.instance().put("KEY_PTN", "ADD");
			} else {
				goBlockBlkKey1();
				/* DCR 2013/10/01 START */
				getTxtBlkKey1EcrNo().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey1RevEcr().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey1Year().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey1Book().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2EcrNo().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2RevEcr().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2Year().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				getTxtBlkKey2Book().setBackground(BaseValidatorConstant.VALIDATION_ERROR_COMPONENT_BACKGROUND_COLOR);
				/* DCR 2013/10/01 END */
				/*
				getTxtBlkKey1EcrNo().setBackground(Color.RED);
				getTxtBlkKey1RevEcr().setBackground(Color.RED);
				getTxtBlkKey1Year().setBackground(Color.RED);
				getTxtBlkKey1Book().setBackground(Color.RED);
				getTxtBlkKey2EcrNo().setBackground(Color.RED);
				getTxtBlkKey2RevEcr().setBackground(Color.RED);
				getTxtBlkKey2Year().setBackground(Color.RED);
				getTxtBlkKey2Book().setBackground(Color.RED);
				*/
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "E-M_INPUTKEY");
				return "INV";
			}
		}

		/*---- USAGE/DETAIL HANDLING ----*/
		if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("KEY_PTN"), "ADD")) {
			if (!BaseStringUtil.isNull(getTxtBlkKey2Year().getValue())) {
				ISZGlobalInfo.instance().put("DATA_TYPE", "ECSU");
			} else {
				ISZGlobalInfo.instance().put("DATA_TYPE", "DTLE");
			}
		} else {
			if (!BaseStringUtil.isNull(getTxtBlkKey1Year().getValue())) {
				ISZGlobalInfo.instance().put("DATA_TYPE", "ECSU");
			} else {
				ISZGlobalInfo.instance().put("DATA_TYPE", "DTLE");
			}
		}

		/*---- INPUT ECS DATA SPEC CHECK ----*/
		if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("KEY_PTN"), "DLT")) {
			strRtn = selectBpUpdFlgAndEcsEffDate((String)getTxtBlkKey1EcrNo().getValue()
												, (String)getTxtBlkKey1RevEcr().getValue()
												, (String)getTxtBlkKey1Year().getValue()
												, (String)getTxtBlkKey1Book().getValue());
			if ("NO_DATA_FOUND".equals(strRtn)) {
				goBlockBlkKey1();
				return "NFF";
			} else if ("OTHERS".equals(strRtn)) {
				return "ERR";
			}
		} else if (ISZFunctionUtil.isFormsEquals((String)ISZGlobalInfo.instance().get("KEY_PTN"), "ADD")) {
			strRtn = selectBpUpdFlgAndEcsEffDate((String)getTxtBlkKey2EcrNo().getValue()
												, (String)getTxtBlkKey2RevEcr().getValue()
												, (String)getTxtBlkKey2Year().getValue()
												, (String)getTxtBlkKey2Book().getValue());
			if ("NO_DATA_FOUND".equals(strRtn)) {
				goBlockBlkKey2();
				return "NFT";
			} else if ("OTHERS".equals(strRtn)) {
				return "ERR";
			}
			
			if ((BaseStringUtil.isNull(getTxtBlkCtrlBpUpdFlg().getValue())
			  && !BaseStringUtil.isNull(getTxtBlkCtrlEcsEffDate().getValue()))
			 || (!BaseStringUtil.isNull(getTxtBlkCtrlBpUpdFlg().getValue())
			  && BaseStringUtil.isNull(getTxtBlkCtrlEcsEffDate().getValue()))) {
				goBlockBlkKey2();
				return "SPC";
			}
		} else {
			strRtn = selectBpUpdFlgAndEcsEffDate((String)getTxtBlkKey1EcrNo().getValue()
					, (String)getTxtBlkKey1RevEcr().getValue()
					, (String)getTxtBlkKey1Year().getValue()
					, (String)getTxtBlkKey1Book().getValue());
			if ("NO_DATA_FOUND".equals(strRtn)) {
				goBlockBlkKey1();
				return "NFF";
			} else if ("OTHERS".equals(strRtn)) {
				return "ERR";
			}
			
			strRtn = selectBpUpdFlgAndEcsEffDate((String)getTxtBlkKey2EcrNo().getValue()
					, (String)getTxtBlkKey2RevEcr().getValue()
					, (String)getTxtBlkKey2Year().getValue()
					, (String)getTxtBlkKey2Book().getValue());
			if ("NO_DATA_FOUND".equals(strRtn)) {
				goBlockBlkKey2();
				return "NFT";
			} else if ("OTHERS".equals(strRtn)) {
				return "ERR";
			}
			
			if ((BaseStringUtil.isNull(getTxtBlkCtrlBpUpdFlg().getValue())
			  && !BaseStringUtil.isNull(getTxtBlkCtrlEcsEffDate().getValue()))
			 || (!BaseStringUtil.isNull(getTxtBlkCtrlBpUpdFlg().getValue())
			  && BaseStringUtil.isNull(getTxtBlkCtrlEcsEffDate().getValue()))) {
				goBlockBlkKey2();
				return "SPC";
			}
		}
		
		return "FIN";
	}
	
	/**
	 * BP_UPD_FLG、ECS_EFF_DATEの検索
	 */
	private String selectBpUpdFlgAndEcsEffDate(String ecrNo, String revEcr, String year, String book) {
		ISZAppRCAServiceInvoker invoker = new ISZAppRCAServiceInvoker(getDbcon());
		CtAppContainer container = new CtAppContainer();
		int rtn = 0;

		try {
			container.setValue("TARGET", "SELECT_BPUPDFLG_AND_ECSEFFDATE");
			container.setValue("USER_ID", parParmUserId);
			container.setValue("ECR_NO", ecrNo);
			container.setValue("REV_ECR", revEcr);
			container.setValue("YEAR", year);
			container.setValue("BOOK", book);
			
			CtAppContainer res = invoker.invoke("ecs", "SrvMSJCF31", container);
			
			rtn = ((BigDecimal)res.getValue("RTN")).intValue();

			if (rtn == 0) {
				getTxtBlkCtrlBpUpdFlg().setValue(res.getValue("BLK_CTRL_BP_UPD_FLG"));
				getTxtBlkCtrlEcsEffDate().setValue(res.getValue("BLK_CTRL_ECS_EFF_DATE"));
			} else {
				// NO_DATA_FOUND
				return "NO_DATA_FOUND";
			}
		} catch (BaseServiceReturnContainerException ex) {
			return "OTHERS";
		} catch (CtAppLogicException ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		} catch (Exception ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		}
		
		return "";
	}

	/**
	 * keyRestore
	 */
	private void keyRestore() {
		
		getTxtBlkKey1EcrNo().setValue(parKey1EcrNo);
		getTxtBlkKey1RevEcr().setValue(parKey1RevEcr);
		getTxtBlkKey1Year().setValue(parKey1Year);
		getTxtBlkKey1Book().setValue(parKey1Book);
		getTxtBlkKey2EcrNo().setValue(parKey2EcrNo);
		getTxtBlkKey2RevEcr().setValue(parKey2RevEcr);
		getTxtBlkKey2Year().setValue(parKey2Year);
		getTxtBlkKey2Book().setValue(parKey2Book);
	}

	/**
	 * keySave
	 */
	private void keySave() {
		
		parKey1EcrNo	= (String)getTxtBlkKey1EcrNo().getValue();
		parKey1RevEcr	= (String)getTxtBlkKey1RevEcr().getValue();
		parKey1Year		= (String)getTxtBlkKey1Year().getValue();
		parKey1Book		= (String)getTxtBlkKey1Book().getValue();
		parKey2EcrNo	= (String)getTxtBlkKey2EcrNo().getValue();
		parKey2RevEcr	= (String)getTxtBlkKey2RevEcr().getValue();
		parKey2Year		= (String)getTxtBlkKey2Year().getValue();
		parKey2Book		= (String)getTxtBlkKey2Book().getValue();
	}

	/**
	 * usageDel
	 */
	private int usageDel() {
		int rtn = 0;
		
		ISZAppRCAServiceInvoker invoker = new ISZAppRCAServiceInvoker(getDbcon());

		try {
			CtAppContainer res = invoker.invoke("ecs", "SrvMSJCF31", makeContainer("USAGE_DEL"));
			rtn = ((BigDecimal)res.getValue("RTN")).intValue();
			getTblMstbecsu().clearStatus();
			getTblMstbdtle().clearStatus();
			if (rtn == 0) {
				// メッセージセット
				CtAppRowSet ecsuRowSet = res.getRowSet("BLK_ECSU1_REP");
				for (int i = 0; i < ecsuRowSet.size(); i++) {
					getTblMstbecsu().setValueAt(ecsuRowSet.getRow(i).getValue("BLK_ECSU1_INTENT"), i, "INTENT");
				}
			}
		} catch (BaseServiceReturnContainerException ex) {

			// BaseServiceReturnContainerExceptionにセットしたContainerを取得
			CtAppContainer responseContainer = ex.getResponseContainer();

			// outputの取得
			String strMessage = BaseStringUtil.nvl(responseContainer.getValue("MSG"));
			CtAppRowSet msgGrpRowSet = responseContainer.getRowSet("MSG_GRP");
			
			// エラーメッセージ処理
			if (msgGrpRowSet != null && msgGrpRowSet.size() > 0) {
				Object msgGrp[] = new Object[msgGrpRowSet.size()];
				for (int i = 0; i < msgGrpRowSet.size(); i++) {
					msgGrp[i] = msgGrpRowSet.getRow(i).getValue("VALUE");
				}
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage, msgGrp);
			} else {
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage);
			}
		} catch (CtAppLogicException ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		} catch (Exception ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		}
		
		return rtn;
	}

	/**
	 * ecscCheck
	 */
	private String ecscCheck(String w_ECR_NO, String w_REV_ECR, String w_YEAR, String w_BOOK, String w_DIVISION) {

		String sts = "0";
		String flg = null;
		String s_ECR_NO     = "     ";
		String s_REV_ECR    = " ";
		String s_YEAR       = "   ";
		String s_BOOK       = "  ";
		String s_DIVISION   = "  ";

	    s_ECR_NO     = w_ECR_NO;
	    s_REV_ECR    = w_REV_ECR;
	    s_YEAR       = w_YEAR;
	    s_BOOK       = w_BOOK;
	    s_DIVISION   = w_DIVISION;
	    
	    flg = selectIemtFlg(s_ECR_NO, s_REV_ECR, s_YEAR, s_BOOK, s_DIVISION);
		
	    if (ISZFunctionUtil.isFormsEquals(flg, "1")) {
	    	sts = flg;
	    } else {
	    	sts = "0";
	    }
	    
		return sts;
	}
	
	/**
	 * MSTBECSC.IEMT_FLGの取得
	 * @return IEMT_FLG
	 */
	private String selectIemtFlg(String s_ECR_NO, String s_REV_ECR, String s_YEAR, String s_BOOK, String s_DIVISION) {
		ISZAppRCAServiceInvoker invoker = new ISZAppRCAServiceInvoker(getDbcon());
		CtAppContainer container = new CtAppContainer();
		String flg = "";

		try {
			container.setValue("TARGET", "SELECT_MSTBECSC_IEMT_FLG");
			container.setValue("USER_ID", parParmUserId);
			container.setValue("ECR_NO", s_ECR_NO);
			container.setValue("REV_ECR", s_REV_ECR);
			container.setValue("YEAR", s_YEAR);
			container.setValue("BOOK", s_BOOK);
			container.setValue("DIVISION", s_DIVISION);
			
			CtAppContainer res = invoker.invoke("ecs", "SrvMSJCF31", container);
			
			flg = (String)res.getValue("IEMT_FLG");
			
		} catch (BaseServiceReturnContainerException ex) {

			// BaseServiceReturnContainerExceptionにセットしたContainerを取得
			CtAppContainer responseContainer = ex.getResponseContainer();

			// outputの取得
			String strMessage = BaseStringUtil.nvl(responseContainer.getValue("MSG"));
			CtAppRowSet msgGrpRowSet = responseContainer.getRowSet("MSG_GRP");
			
			// エラーメッセージ処理
			if (msgGrpRowSet != null && msgGrpRowSet.size() > 0) {
				Object msgGrp[] = new Object[msgGrpRowSet.size()];
				for (int i = 0; i < msgGrpRowSet.size(); i++) {
					msgGrp[i] = msgGrpRowSet.getRow(i).getValue("VALUE");
				}
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage, msgGrp);
			} else {
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage);
			}
		} catch (CtAppLogicException ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		} catch (Exception ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		}
		
		return flg;
	}

	/**
	 * 全項目をパラメータ作成
	 * @param _strTarget サービス呼出分岐
	 * @return
	 */
	private CtAppContainer makeContainer(String _strTarget) {
		CtAppContainer container = new CtAppContainer();

        // service　target
        container.setValue("TARGET", _strTarget);
		container.setValue("USER_ID", parParmUserId);
        container.setValue("C_MYCNTRY", parParmCntryGrp);
		
		// 必要なグローバル変数
		container.setValue("GLOBAL_DATA_TYPE", (String)ISZGlobalInfo.instance().get("DATA_TYPE"));
		
        // BLK_CTRL
        container.setValue("BLK_CTRL_INS_CNT", getTxtBlkCtrlInsCnt().getValue());
        container.setValue("BLK_CTRL_UPD_CNT", getTxtBlkCtrlUpdCnt().getValue());
        container.setValue("BLK_CTRL_BP_UPD_FLG", getTxtBlkCtrlBpUpdFlg().getValue());
        container.setValue("BLK_CTRL_ECS_EFF_DATE", getTxtBlkCtrlEcsEffDate().getValue());
        container.setValue("BLK_CTRL_BP_START_DATE", getTxtBlkCtrlBpStartDate().getValue());
        container.setValue("BLK_CTRL_BP_START_ECR_NO", getTxtBlkCtrlBpStartEcrNo().getValue());
        container.setValue("BLK_CTRL_BP_START_REV_ECR", getTxtBlkCtrlBpStartRevEcr().getValue());
        container.setValue("BLK_CTRL_BP_STOP_DATE", getTxtBlkCtrlBpStopDate().getValue());
        container.setValue("BLK_CTRL_BP_STOP_ECR_NO", getTxtBlkCtrlBpStopEcrNo().getValue());
        container.setValue("BLK_CTRL_BP_STOP_REV_ECR", getTxtBlkCtrlBpStopRevEcr().getValue());
        
        // condition
        container.setValue("BLK_KEY1_ECR_NO", getTxtBlkKey1EcrNo().getValue());
        container.setValue("BLK_KEY1_REV_ECR", getTxtBlkKey1RevEcr().getValue());
        container.setValue("BLK_KEY1_YEAR", getTxtBlkKey1Year().getValue());
        container.setValue("BLK_KEY1_BOOK", getTxtBlkKey1Book().getValue());
        container.setValue("BLK_KEY2_ECR_NO", getTxtBlkKey2EcrNo().getValue());
        container.setValue("BLK_KEY2_REV_ECR", getTxtBlkKey2RevEcr().getValue());
        container.setValue("BLK_KEY2_YEAR", getTxtBlkKey2Year().getValue());
        container.setValue("BLK_KEY2_BOOK", getTxtBlkKey2Book().getValue());
        
        // BLK_ECSU1
        CtAppRowSet blkEcsuRowSet = container.getRowSet("BLK_ECSU1");
        for (int i = 0; i < getTblMstbecsu().getRowCount(); i++) {
            CtAppRow blkEcsuRow = blkEcsuRowSet.createRow();

            // NONE
            if (getTblMstbecsu().getRowStatus(i) == null) {
            	blkEcsuRow.setStatus(CtAppRow.NONE_STATUS);
            // 新規
            } else if (getTblMstbecsu().getRowStatus(i).equals(CtCustomConstants.DATA_CREATED)) {
            	blkEcsuRow.setStatus(CtAppRow.NEW_STATUS);
            // 変更
            } else if (getTblMstbecsu().getRowStatus(i).equals(CtCustomConstants.DATA_CHANGED)) {
            	blkEcsuRow.setStatus(CtAppRow.UPDATE_STATUS);
            // 削除
            } else if (getTblMstbecsu().getRowStatus(i).equals(CtCustomConstants.DATA_DELETED)) {
            	blkEcsuRow.setStatus(CtAppRow.DELETE_STATUS);
            }
            blkEcsuRow.setValue("BLK_ECSU1_START_STOP", getTblMstbecsu().getValueAt(i, "+/-"));
            blkEcsuRow.setValue("BLK_ECSU1_ECR_NO", getTblMstbecsu().getValueAt(i, "ECR_NO"));
            blkEcsuRow.setValue("BLK_ECSU1_REV_ECR", getTblMstbecsu().getValueAt(i, "REV_ECR"));
            blkEcsuRow.setValue("BLK_ECSU1_YEAR", getTblMstbecsu().getValueAt(i, "YEAR"));
            blkEcsuRow.setValue("BLK_ECSU1_BOOK", getTblMstbecsu().getValueAt(i, "BOOK"));
            blkEcsuRow.setValue("BLK_ECSU1_PART_NO", getTblMstbecsu().getValueAt(i, "Part"));
            blkEcsuRow.setValue("BLK_ECSU1_UPC", getTblMstbecsu().getValueAt(i, "Upc"));
            blkEcsuRow.setValue("BLK_ECSU1_FNA", getTblMstbecsu().getValueAt(i, "Fna"));
            blkEcsuRow.setValue("BLK_ECSU1_USAGE_CODE", getTblMstbecsu().getValueAt(i, "Usage"));
            blkEcsuRow.setValue("BLK_ECSU1_UNIT_QTY", getTblMstbecsu().getValueAt(i, "Qty"));
            blkEcsuRow.setValue("BLK_ECSU1_START_STOP_FLG", getTblMstbecsu().getValueAt(i, "START_STOP_FLG"));
            blkEcsuRow.setValue("BLK_ECSU1_INTENT", getTblMstbecsu().getValueAt(i, "INTENT"));
            blkEcsuRow.setValue("BLK_ECSU1_ECSU_MESSAGE", getTblMstbecsu().getValueAt(i, "Message"));
        }
        
        // BLK_DTLE1
        CtAppRowSet blkDtleRowSet = container.getRowSet("BLK_DTLE1");
        for (int i = 0; i < getTblMstbdtle().getRowCount(); i++) {
            CtAppRow blkDtleRow = blkDtleRowSet.createRow();

            // NONE
            if (getTblMstbdtle().getRowStatus(i) == null) {
            	blkDtleRow.setStatus(CtAppRow.NONE_STATUS);
            // 新規
            } else if (getTblMstbdtle().getRowStatus(i).equals(CtCustomConstants.DATA_CREATED)) {
            	blkDtleRow.setStatus(CtAppRow.NEW_STATUS);
            // 変更
            } else if (getTblMstbdtle().getRowStatus(i).equals(CtCustomConstants.DATA_CHANGED)) {
            	blkDtleRow.setStatus(CtAppRow.UPDATE_STATUS);
            // 削除
            } else if (getTblMstbdtle().getRowStatus(i).equals(CtCustomConstants.DATA_DELETED)) {
            	blkDtleRow.setStatus(CtAppRow.DELETE_STATUS);
            }
            blkDtleRow.setValue("BLK_DTLE1_START_STOP", getTblMstbdtle().getValueAt(i, "+/-"));
            blkDtleRow.setValue("BLK_DTLE1_ECR_NO", getTblMstbdtle().getValueAt(i, "ECR_NO"));
            blkDtleRow.setValue("BLK_DTLE1_REV_ECR", getTblMstbdtle().getValueAt(i, "REV_ECR"));
            blkDtleRow.setValue("BLK_DTLE1_YEAR", getTblMstbdtle().getValueAt(i, "YEAR"));
            blkDtleRow.setValue("BLK_DTLE1_BOOK", getTblMstbdtle().getValueAt(i, "BOOK"));
            blkDtleRow.setValue("BLK_DTLE1_PART_NO", getTblMstbdtle().getValueAt(i, "Part"));
            blkDtleRow.setValue("BLK_DTLE1_DETAIL_SEQ", getTblMstbdtle().getValueAt(i, "Seq"));
            blkDtleRow.setValue("BLK_DTLE1_DETAIL_PART", getTblMstbdtle().getValueAt(i, "Dtl-Part"));
            blkDtleRow.setValue("BLK_DTLE1_DETAIL_UPC", getTblMstbdtle().getValueAt(i, "Upc"));
            blkDtleRow.setValue("BLK_DTLE1_DETAIL_FNA", getTblMstbdtle().getValueAt(i, "Fna"));
            blkDtleRow.setValue("BLK_DTLE1_DETAIL_QTY", getTblMstbdtle().getValueAt(i, "Qty"));
            blkDtleRow.setValue("BLK_DTLE1_START_STOP_FLG", getTblMstbdtle().getValueAt(i, "START_STOP_FLG"));
            blkDtleRow.setValue("BLK_DTLE1_INTENT", getTblMstbdtle().getValueAt(i, "INTENT"));
            blkDtleRow.setValue("BLK_DTLE1_DTLE_MESSAGE", getTblMstbdtle().getValueAt(i, "Message"));
        }
		
		return container;
	}

	/**
	 * insertProc
	 */
	private int insertProc() {
		int rtn = 0;
		int ecsl_cnt = 0;
		String ecsc_sts2 = null;
		
		BaseAutoFilterTableModel filterModelEcsu = (BaseAutoFilterTableModel)getTblMstbecsu().getModel();
		BaseResultSetTableModel modelEcsu = (BaseResultSetTableModel)filterModelEcsu.getTableModel();
		
		// 一覧表のエラー状態をクリア
		modelEcsu.setTableModelCellStatusToNormalAllCells();
		
		if (ISZFunctionUtil.isFormsNotEquals((String)getTblMstbecsu().getValueAt(getTblMstbecsu().getSelectedRow(), "+/-"), "+")
		 && ISZFunctionUtil.isFormsNotEquals((String)getTblMstbecsu().getValueAt(getTblMstbecsu().getSelectedRow(), "+/-"), "-")) {
			
			modelEcsu.setTableModelCellStatus(getTblMstbecsu().getSelectedRow(), "+/-", "",BaseTableModelCellStatusControl.CELL_STATUS_ERROR);
			return 1;
		}
		
		ecsl_cnt = selectMstbecslCount((String)getTxtBlkKey2EcrNo().getValue()
									, (String)getTxtBlkKey2RevEcr().getValue()
									, (String)getTxtBlkKey2Year().getValue()
									, (String)getTxtBlkKey2Book().getValue());
		
		if (ecsl_cnt == 0) {
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "I-CMN-0008");
			return 1;
		}
		
		ecsc_sts2 = ecscCheck((String)getTxtBlkKey2EcrNo().getValue()
							, (String)getTxtBlkKey2RevEcr().getValue()
							, (String)getTxtBlkKey2Year().getValue()
							, (String)getTxtBlkKey2Book().getValue()
							, "  ");
		if (ISZFunctionUtil.isFormsEquals(ecsc_sts2, "1")) {
			parParmIemt = "1";
		} else {
			parParmIemt = "0";
		}
		
		if (ISZFunctionUtil.isFormsEquals(parParmIemtuser, "1")
		 && ISZFunctionUtil.isFormsEquals(parParmIemt, "0")) {
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), "E-M_ISZTUPDATE");
		    return 1;
		}
		
		if (ISZFunctionUtil.isFormsEquals(parParmIemtuser, "0")
		 && ISZFunctionUtil.isFormsEquals(parParmIemt, "1")) {
			if (!BaseMessageIndicator.confirm(getTxtBlkKey1EcrNo(), "Q-M_COMMON", new Object[]{ISZFunctionUtil.getMessageById("E-A_IEMTUPDATE")})) {
			    return 1;
			}
		}
		
		getTxtBlkCtrlUpdCnt().setValue("0");
		
		ISZAppRCAServiceInvoker invoker = new ISZAppRCAServiceInvoker(getDbcon());

		try {
			CtAppContainer res = invoker.invoke("ecs", "SrvMSJCF31", makeContainer("INSERT_PROC"));
			
			rtn = ((BigDecimal)res.getValue("RTN")).intValue();
			if (rtn != 0) {
				String strMessage = BaseStringUtil.nvl(res.getValue("MSG"));
				CtAppRowSet msgGrpRowSet = res.getRowSet("MSG_GRP");
				String row = BaseStringUtil.nvl(res.getValue("ROW"));
				
				// エラー色処理
				if (!BaseStringUtil.isNull(row)) {
					modelEcsu.setTableModelCellStatus(Integer.parseInt(row), "Part", "",BaseTableModelCellStatusControl.CELL_STATUS_ERROR);
					modelEcsu.setTableModelCellStatus(Integer.parseInt(row), "Upc", "",BaseTableModelCellStatusControl.CELL_STATUS_ERROR);
					modelEcsu.setTableModelCellStatus(Integer.parseInt(row), "Fna", "",BaseTableModelCellStatusControl.CELL_STATUS_ERROR);
					modelEcsu.setTableModelCellStatus(Integer.parseInt(row), "Usage", "",BaseTableModelCellStatusControl.CELL_STATUS_ERROR);
					modelEcsu.setTableModelCellStatus(Integer.parseInt(row), "Qty", "",BaseTableModelCellStatusControl.CELL_STATUS_ERROR);
					modelEcsu.setTableModelCellStatus(Integer.parseInt(row), "+/-", "",BaseTableModelCellStatusControl.CELL_STATUS_ERROR);
				}
				
				// エラーメッセージ処理
				if (msgGrpRowSet != null && msgGrpRowSet.size() > 0) {
					Object msgGrp[] = new Object[msgGrpRowSet.size()];
					for (int i = 0; i < msgGrpRowSet.size(); i++) {
						msgGrp[i] = msgGrpRowSet.getRow(i).getValue("VALUE");
					}
					BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage, msgGrp);
				} else {
					BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage);
				}
				return rtn;
			} else {
				int updCnt = 0;
				// メッセージセット
				CtAppRowSet ecsuRowSet = res.getRowSet("BLK_ECSU1_REP");
				for (int i = 0; i < ecsuRowSet.size(); i++) {
					/* 2014/03/20 DCR START */
					if (BaseStringUtil.isNull(getTblMstbecsu().getValueAt(i, "Message"))) {
					/* 2014/03/20 DCR END */
						getTblMstbecsu().setValueAt(ecsuRowSet.getRow(i).getValue("BLK_ECSU1_ECSU_MESSAGE"), i, "Message");
						if (!BaseStringUtil.isNull(ecsuRowSet.getRow(i).getValue("BLK_ECSU1_ECSU_MESSAGE"))) {
							updCnt++;
						}
					}
				}
				// 件数更新
				getTxtBlkCtrlUpdCnt().setValue(String.valueOf(updCnt));
			}
		} catch (BaseServiceReturnContainerException ex) {

			// BaseServiceReturnContainerExceptionにセットしたContainerを取得
			CtAppContainer responseContainer = ex.getResponseContainer();

			// outputの取得
			String strMessage = BaseStringUtil.nvl(responseContainer.getValue("MSG"));
			CtAppRowSet msgGrpRowSet = responseContainer.getRowSet("MSG_GRP");
			
			// エラーメッセージ処理
			if (msgGrpRowSet != null && msgGrpRowSet.size() > 0) {
				Object msgGrp[] = new Object[msgGrpRowSet.size()];
				for (int i = 0; i < msgGrpRowSet.size(); i++) {
					msgGrp[i] = msgGrpRowSet.getRow(i).getValue("VALUE");
				}
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage, msgGrp);
			} else {
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage);
			}
		} catch (CtAppLogicException ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		} catch (Exception ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		}
		
		return rtn;
	}
	
	/**
	 * MSTBECSL_COUNTの検索
	 */
	private int selectMstbecslCount(String ecrNo, String revEcr, String year, String book) {
		ISZAppRCAServiceInvoker invoker = new ISZAppRCAServiceInvoker(getDbcon());
		CtAppContainer container = new CtAppContainer();
		int cnt = 0;

		try {
			container.setValue("TARGET", "SELECT_MSTBECSL_COUNT");
			container.setValue("USER_ID", parParmUserId);
			container.setValue("ECR_NO", ecrNo);
			container.setValue("REV_ECR", revEcr);
			container.setValue("YEAR", year);
			container.setValue("BOOK", book);
			
			CtAppContainer res = invoker.invoke("ecs", "SrvMSJCF31", container);
			
			cnt = ((BigDecimal)res.getValue("ECSL_CNT")).intValue();
			
		} catch (BaseServiceReturnContainerException ex) {

			// BaseServiceReturnContainerExceptionにセットしたContainerを取得
			CtAppContainer responseContainer = ex.getResponseContainer();

			// outputの取得
			String strMessage = BaseStringUtil.nvl(responseContainer.getValue("MSG"));
			CtAppRowSet msgGrpRowSet = responseContainer.getRowSet("MSG_GRP");
			
			// エラーメッセージ処理
			if (msgGrpRowSet != null && msgGrpRowSet.size() > 0) {
				Object msgGrp[] = new Object[msgGrpRowSet.size()];
				for (int i = 0; i < msgGrpRowSet.size(); i++) {
					msgGrp[i] = msgGrpRowSet.getRow(i).getValue("VALUE");
				}
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage, msgGrp);
			} else {
				BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), strMessage);
			}
		} catch (CtAppLogicException ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		} catch (Exception ex) {
			BaseLog.error(ex);
			BaseMessageIndicator.indicate(getTxtBlkKey1EcrNo(), ex.getMessage());
		}
		
		return cnt;
	}
	
	/**
	 * This method initializes ccpMstbecsuIntent	
	 * 	
	 * @return com.classtechnology.base.common.custom.gui.table.BaseCheckBoxCellComponent	
	 */
	private BaseCheckBoxCellComponent getCcpMstbecsuIntent() {
		if (ccpMstbecsuIntent == null) {
			ccpMstbecsuIntent = new BaseCheckBoxCellComponent();
			ccpMstbecsuIntent.setSize(new Dimension(29, 26));
			ccpMstbecsuIntent.setColumnNameInfo(new com.classtechnology.custom.gui.table.CtTableColumnNameInfo("INTENT"));
			ccpMstbecsuIntent.setToggleButtonValueInfo(new com.classtechnology.custom.gui.CtToggleButtonValueInfo(new java.lang.Object[][] {
				new java.lang.Object[] { com.classtechnology.custom.gui.CtToggleButtonValueInfo.PROP_UNSELECTED_VALUE, "OF" },
				new java.lang.Object[] { com.classtechnology.custom.gui.CtToggleButtonValueInfo.PROP_VALUE_TYPE, "String" },
				new java.lang.Object[] { com.classtechnology.custom.gui.CtToggleButtonValueInfo.PROP_SELECTED_VALUE, "ON" }
			}));
			ccpMstbecsuIntent.setTable(getTblMstbecsu());
		}
		return ccpMstbecsuIntent;
	}

	/**
	 * This method initializes funcInsertEcsu	
	 * 	
	 * @return com.classtechnology.base.common.custom.function.BaseFunctionRef	
	 */
	private BaseFunctionRef getFuncInsertEcsu() {
		if (funcInsertEcsu == null) {
			funcInsertEcsu = new BaseFunctionRef();
			funcInsertEcsu.setFunctionNameInfo(new com.classtechnology.custom.function.CtFunctionNameInfo("tableAddRow"));
			funcInsertEcsu.setFunctionProvider(getTblMstbecsu());
		}
		return funcInsertEcsu;
	}
	/**
	 * This method initializes funcInsertDtle	
	 * 	
	 * @return com.classtechnology.base.common.custom.function.BaseFunctionRef	
	 */
	private BaseFunctionRef getFuncInsertDtle() {
		if (funcInsertDtle == null) {
			funcInsertDtle = new BaseFunctionRef();
			funcInsertDtle.setFunctionNameInfo(new com.classtechnology.custom.function.CtFunctionNameInfo("tableAddRow"));
			funcInsertDtle.setFunctionProvider(getTblMstbdtle());
		}
		return funcInsertDtle;
	}
	/**
	 * This method initializes ccpMstbdtleIntent	
	 * 	
	 * @return com.classtechnology.base.common.custom.gui.table.BaseCheckBoxCellComponent	
	 */
	private BaseCheckBoxCellComponent getCcpMstbdtleIntent() {
		if (ccpMstbdtleIntent == null) {
			ccpMstbdtleIntent = new BaseCheckBoxCellComponent();
			ccpMstbdtleIntent.setSize(new Dimension(31, 28));
			ccpMstbdtleIntent.setColumnNameInfo(new com.classtechnology.custom.gui.table.CtTableColumnNameInfo("INTENT"));
			ccpMstbdtleIntent.setTable(getTblMstbdtle());
			ccpMstbdtleIntent.setToggleButtonValueInfo(new com.classtechnology.custom.gui.CtToggleButtonValueInfo(new java.lang.Object[][] {
				new java.lang.Object[] { com.classtechnology.custom.gui.CtToggleButtonValueInfo.PROP_UNSELECTED_VALUE, "OF" },
				new java.lang.Object[] { com.classtechnology.custom.gui.CtToggleButtonValueInfo.PROP_VALUE_TYPE, "String" },
				new java.lang.Object[] { com.classtechnology.custom.gui.CtToggleButtonValueInfo.PROP_SELECTED_VALUE, "ON" }
			}));
		}
		return ccpMstbdtleIntent;
	}
	/**
	 * This method initializes relCndEcsu1BlkKey2EcrNo	
	 * 	
	 * @return com.classtechnology.custom.relation.CtNamedComponentRelation	
	 */
	private CtNamedComponentRelation getRelCndEcsu1BlkKey2EcrNo() {
		if (relCndEcsu1BlkKey2EcrNo == null) {
			relCndEcsu1BlkKey2EcrNo = new CtNamedComponentRelation();
			relCndEcsu1BlkKey2EcrNo.setRelationNameInfo(new com.classtechnology.custom.relation.CtRelationNameInfo("CND_ECR_NO"));
			relCndEcsu1BlkKey2EcrNo.setComponent(getTxtBlkKey2EcrNo());
			relCndEcsu1BlkKey2EcrNo.setRelationSet(getDcmBlkEcsu1Key2());
		}
		return relCndEcsu1BlkKey2EcrNo;
	}
	/**
	 * This method initializes relCndEcsu1BlkKey2Year	
	 * 	
	 * @return com.classtechnology.custom.relation.CtNamedComponentRelation	
	 */
	private CtNamedComponentRelation getRelCndEcsu1BlkKey2Year() {
		if (relCndEcsu1BlkKey2Year == null) {
			relCndEcsu1BlkKey2Year = new CtNamedComponentRelation();
			relCndEcsu1BlkKey2Year.setRelationNameInfo(new com.classtechnology.custom.relation.CtRelationNameInfo("CND_YEAR"));
			relCndEcsu1BlkKey2Year.setComponent(getTxtBlkKey2Year());
			relCndEcsu1BlkKey2Year.setRelationSet(getDcmBlkEcsu1Key2());
		}
		return relCndEcsu1BlkKey2Year;
	}
	/**
	 * This method initializes relCndEcsu1BlkKey2Book	
	 * 	
	 * @return com.classtechnology.custom.relation.CtNamedComponentRelation	
	 */
	private CtNamedComponentRelation getRelCndEcsu1BlkKey2Book() {
		if (relCndEcsu1BlkKey2Book == null) {
			relCndEcsu1BlkKey2Book = new CtNamedComponentRelation();
			relCndEcsu1BlkKey2Book.setRelationNameInfo(new com.classtechnology.custom.relation.CtRelationNameInfo("CND_BOOK"));
			relCndEcsu1BlkKey2Book.setComponent(getTxtBlkKey2Book());
			relCndEcsu1BlkKey2Book.setRelationSet(getDcmBlkEcsu1Key2());
		}
		return relCndEcsu1BlkKey2Book;
	}
	/**
	 * This method initializes relCndDtle1BlkKey2EcrNo	
	 * 	
	 * @return com.classtechnology.custom.relation.CtNamedComponentRelation	
	 */
	private CtNamedComponentRelation getRelCndDtle1BlkKey2EcrNo() {
		if (relCndDtle1BlkKey2EcrNo == null) {
			relCndDtle1BlkKey2EcrNo = new CtNamedComponentRelation();
			relCndDtle1BlkKey2EcrNo.setRelationNameInfo(new com.classtechnology.custom.relation.CtRelationNameInfo("CND_ECR_NO"));
			relCndDtle1BlkKey2EcrNo.setComponent(getTxtBlkKey2EcrNo());
			relCndDtle1BlkKey2EcrNo.setRelationSet(getDcmBlkDtle1Key2());
		}
		return relCndDtle1BlkKey2EcrNo;
	}
	/**
	 * This method initializes relCndDtle1BlkKey2Year	
	 * 	
	 * @return com.classtechnology.custom.relation.CtNamedComponentRelation	
	 */
	private CtNamedComponentRelation getRelCndDtle1BlkKey2Year() {
		if (relCndDtle1BlkKey2Year == null) {
			relCndDtle1BlkKey2Year = new CtNamedComponentRelation();
			relCndDtle1BlkKey2Year.setRelationNameInfo(new com.classtechnology.custom.relation.CtRelationNameInfo("CND_YEAR"));
			relCndDtle1BlkKey2Year.setComponent(getTxtBlkKey2Year());
			relCndDtle1BlkKey2Year.setRelationSet(getDcmBlkDtle1Key2());
		}
		return relCndDtle1BlkKey2Year;
	}
	/**
	 * This method initializes relCndDtle1BlkKey2Book	
	 * 	
	 * @return com.classtechnology.custom.relation.CtNamedComponentRelation	
	 */
	private CtNamedComponentRelation getRelCndDtle1BlkKey2Book() {
		if (relCndDtle1BlkKey2Book == null) {
			relCndDtle1BlkKey2Book = new CtNamedComponentRelation();
			relCndDtle1BlkKey2Book.setRelationNameInfo(new com.classtechnology.custom.relation.CtRelationNameInfo("CND_BOOK"));
			relCndDtle1BlkKey2Book.setComponent(getTxtBlkKey2Book());
			relCndDtle1BlkKey2Book.setRelationSet(getDcmBlkDtle1Key2());
		}
		return relCndDtle1BlkKey2Book;
	}
	/**
	 * This method initializes funcDeleteEcsu	
	 * 	
	 * @return com.classtechnology.base.common.custom.function.BaseFunctionRef	
	 */
	private BaseFunctionRef getFuncDeleteEcsu() {
		if (funcDeleteEcsu == null) {
			funcDeleteEcsu = new BaseFunctionRef();
			funcDeleteEcsu.setFunctionNameInfo(new com.classtechnology.custom.function.CtFunctionNameInfo("tableRemoveRow"));
			funcDeleteEcsu.setFunctionProvider(getTblMstbecsu());
		}
		return funcDeleteEcsu;
	}
	
	/**
	 * go_block blk_key1
	 */
	private void goBlockBlkKey1() {
		getTxtBlkKey1EcrNo().requestFocus();
	}
	
	/**
	 * go_block blk_key2
	 */
	private void goBlockBlkKey2() {
		getTxtBlkKey2EcrNo().requestFocus();
	}
	/**
	 * This method initializes funcSearchDtle	
	 * 	
	 * @return com.classtechnology.base.common.custom.function.BaseFunctionRef	
	 */
	private BaseFunctionRef getFuncSearchDtle() {
		if (funcSearchDtle == null) {
			funcSearchDtle = new BaseFunctionRef();
			funcSearchDtle.setFunctionNameInfo(new com.classtechnology.custom.function.CtFunctionNameInfo("tableQueryFunction"));
			funcSearchDtle.setFunctionProvider(getTblMstbdtle());
		}
		return funcSearchDtle;
	}
	/**
	 * This method initializes funcSearchEcsu	
	 * 	
	 * @return com.classtechnology.base.common.custom.function.BaseFunctionRef	
	 */
	private BaseFunctionRef getFuncSearchEcsu() {
		if (funcSearchEcsu == null) {
			funcSearchEcsu = new BaseFunctionRef();
			funcSearchEcsu.setFunctionNameInfo(new com.classtechnology.custom.function.CtFunctionNameInfo("tableQueryFunction"));
			funcSearchEcsu.setFunctionProvider(getTblMstbecsu());
		}
		return funcSearchEcsu;
	}
	
	/**
	 * blk_key2フォーカスを取得時
	 */
	private void procBlkKey2FocusGained() {
		if (ISZFunctionUtil.isFormsEquals(parProcessMode, "INSERT")) {
			if (beforeItem != getTxtBlkKey2EcrNo()
			 && beforeItem != getTxtBlkKey2RevEcr()
			 && beforeItem != getTxtBlkKey2Year()
			 && beforeItem != getTxtBlkKey2Book()) {
				getTxtBlkKey2EcrNo().setBackground(Color.WHITE);
				getTxtBlkKey2RevEcr().setBackground(Color.WHITE);
				getTxtBlkKey2Year().setBackground(Color.WHITE);
				getTxtBlkKey2Book().setBackground(Color.WHITE);
			}
		}
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"