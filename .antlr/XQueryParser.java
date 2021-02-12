// Generated from /Users/zouhongyu/Desktop/CSE232B_XQueryEvaluator/XQuery.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XQueryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, DOC=34, IS=35, NAME=36, STR=37, WS=38;
	public static final int
		RULE_xq = 0, RULE_forclause = 1, RULE_letclause = 2, RULE_whereclause = 3, 
		RULE_returnclause = 4, RULE_cond = 5, RULE_var = 6, RULE_ap = 7, RULE_rp = 8, 
		RULE_f = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"xq", "forclause", "letclause", "whereclause", "returnclause", "cond", 
			"var", "ap", "rp", "f"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'/'", "'//'", "'<'", "'>'", "'{'", "'}'", 
			"'for'", "'in'", "'let'", "':='", "'where'", "'return'", "'='", "'eq'", 
			"'empty'", "'some'", "'satisfies'", "'and'", "'or'", "'not'", "'$'", 
			"'(\"'", "'\")'", "'*'", "'.'", "'..'", "'text()'", "'@'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "DOC", "IS", 
			"NAME", "STR", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "XQuery.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQueryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class XqContext extends ParserRuleContext {
		public XqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xq; }
	 
		public XqContext() { }
		public void copyFrom(XqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class XqApContext extends XqContext {
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public XqApContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class XqVarContext extends XqContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public XqVarContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class XqParenContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XqParenContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class XqIndirectChildContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XqIndirectChildContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class XqStrContext extends XqContext {
		public TerminalNode STR() { return getToken(XQueryParser.STR, 0); }
		public XqStrContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class XqClauseContext extends XqContext {
		public ForclauseContext forclause() {
			return getRuleContext(ForclauseContext.class,0);
		}
		public ReturnclauseContext returnclause() {
			return getRuleContext(ReturnclauseContext.class,0);
		}
		public LetclauseContext letclause() {
			return getRuleContext(LetclauseContext.class,0);
		}
		public WhereclauseContext whereclause() {
			return getRuleContext(WhereclauseContext.class,0);
		}
		public XqClauseContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class XqDirectChildContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XqDirectChildContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class XqConcatContext extends XqContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public XqConcatContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class XqLetContext extends XqContext {
		public LetclauseContext letclause() {
			return getRuleContext(LetclauseContext.class,0);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XqLetContext(XqContext ctx) { copyFrom(ctx); }
	}
	public static class XqTagContext extends XqContext {
		public List<TerminalNode> NAME() { return getTokens(XQueryParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(XQueryParser.NAME, i);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XqTagContext(XqContext ctx) { copyFrom(ctx); }
	}

	public final XqContext xq() throws RecognitionException {
		return xq(0);
	}

	private XqContext xq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XqContext _localctx = new XqContext(_ctx, _parentState);
		XqContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_xq, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				{
				_localctx = new XqVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(21);
				var();
				}
				break;
			case STR:
				{
				_localctx = new XqStrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				match(STR);
				}
				break;
			case DOC:
				{
				_localctx = new XqApContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				ap();
				}
				break;
			case T__0:
				{
				_localctx = new XqParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(T__0);
				setState(25);
				xq(0);
				setState(26);
				match(T__1);
				}
				break;
			case T__5:
				{
				_localctx = new XqTagContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				match(T__5);
				setState(29);
				match(NAME);
				setState(30);
				match(T__6);
				setState(31);
				match(T__7);
				setState(32);
				xq(0);
				setState(33);
				match(T__8);
				setState(34);
				match(T__5);
				setState(35);
				match(T__3);
				setState(36);
				match(NAME);
				setState(37);
				match(T__6);
				}
				break;
			case T__9:
				{
				_localctx = new XqClauseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(39);
				forclause();
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(40);
					letclause();
					}
				}

				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(43);
					whereclause();
					}
				}

				setState(46);
				returnclause();
				}
				break;
			case T__11:
				{
				_localctx = new XqLetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
				letclause();
				setState(49);
				xq(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(62);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new XqConcatContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(53);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(54);
						match(T__2);
						setState(55);
						xq(7);
						}
						break;
					case 2:
						{
						_localctx = new XqDirectChildContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(56);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(57);
						match(T__3);
						setState(58);
						rp(0);
						}
						break;
					case 3:
						{
						_localctx = new XqIndirectChildContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(59);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(60);
						match(T__4);
						setState(61);
						rp(0);
						}
						break;
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ForclauseContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public ForclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forclause; }
	}

	public final ForclauseContext forclause() throws RecognitionException {
		ForclauseContext _localctx = new ForclauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_forclause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__9);
			setState(68);
			var();
			setState(69);
			match(T__10);
			setState(70);
			xq(0);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(71);
				match(T__2);
				setState(72);
				var();
				setState(73);
				match(T__10);
				setState(74);
				xq(0);
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LetclauseContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public LetclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letclause; }
	}

	public final LetclauseContext letclause() throws RecognitionException {
		LetclauseContext _localctx = new LetclauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_letclause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__11);
			setState(82);
			var();
			setState(83);
			match(T__12);
			setState(84);
			xq(0);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(85);
				match(T__2);
				setState(86);
				var();
				setState(87);
				match(T__12);
				setState(88);
				xq(0);
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereclauseContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public WhereclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereclause; }
	}

	public final WhereclauseContext whereclause() throws RecognitionException {
		WhereclauseContext _localctx = new WhereclauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_whereclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__13);
			setState(96);
			cond(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnclauseContext extends ParserRuleContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public ReturnclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnclause; }
	}

	public final ReturnclauseContext returnclause() throws RecognitionException {
		ReturnclauseContext _localctx = new ReturnclauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_returnclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__14);
			setState(99);
			xq(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondContext extends ParserRuleContext {
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
	 
		public CondContext() { }
		public void copyFrom(CondContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CondEmptyContext extends CondContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public CondEmptyContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class CondIsContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public TerminalNode IS() { return getToken(XQueryParser.IS, 0); }
		public CondIsContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class CondSomeContext extends CondContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CondSomeContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class CondParenContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CondParenContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class CondAndContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public CondAndContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class CondOrContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public CondOrContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class CondEq2Context extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public CondEq2Context(CondContext ctx) { copyFrom(ctx); }
	}
	public static class CondEq1Context extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public CondEq1Context(CondContext ctx) { copyFrom(ctx); }
	}
	public static class CondNotContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CondNotContext(CondContext ctx) { copyFrom(ctx); }
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_cond, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new CondEq1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(102);
				xq(0);
				setState(103);
				match(T__15);
				setState(104);
				xq(0);
				}
				break;
			case 2:
				{
				_localctx = new CondEq2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106);
				xq(0);
				setState(107);
				match(T__16);
				setState(108);
				xq(0);
				}
				break;
			case 3:
				{
				_localctx = new CondIsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110);
				xq(0);
				setState(111);
				match(IS);
				setState(112);
				xq(0);
				}
				break;
			case 4:
				{
				_localctx = new CondEmptyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114);
				match(T__17);
				setState(115);
				match(T__0);
				setState(116);
				xq(0);
				setState(117);
				match(T__1);
				}
				break;
			case 5:
				{
				_localctx = new CondSomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				match(T__18);
				setState(120);
				var();
				setState(121);
				match(T__10);
				setState(122);
				xq(0);
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(123);
					match(T__2);
					setState(124);
					var();
					setState(125);
					match(T__10);
					setState(126);
					xq(0);
					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(133);
				match(T__19);
				setState(134);
				cond(5);
				}
				break;
			case 6:
				{
				_localctx = new CondParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				match(T__0);
				setState(137);
				cond(0);
				setState(138);
				match(T__1);
				}
				break;
			case 7:
				{
				_localctx = new CondNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(T__22);
				setState(141);
				cond(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(150);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new CondAndContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(144);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(145);
						match(T__20);
						setState(146);
						cond(4);
						}
						break;
					case 2:
						{
						_localctx = new CondOrContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(147);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(148);
						match(T__21);
						setState(149);
						cond(3);
						}
						break;
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(XQueryParser.NAME, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(T__23);
			setState(156);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ApContext extends ParserRuleContext {
		public ApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ap; }
	 
		public ApContext() { }
		public void copyFrom(ApContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DirectChildContext extends ApContext {
		public TerminalNode DOC() { return getToken(XQueryParser.DOC, 0); }
		public TerminalNode NAME() { return getToken(XQueryParser.NAME, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public DirectChildContext(ApContext ctx) { copyFrom(ctx); }
	}
	public static class IndirectChildContext extends ApContext {
		public TerminalNode DOC() { return getToken(XQueryParser.DOC, 0); }
		public TerminalNode NAME() { return getToken(XQueryParser.NAME, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public IndirectChildContext(ApContext ctx) { copyFrom(ctx); }
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ap);
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new DirectChildContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(DOC);
				setState(159);
				match(T__24);
				setState(160);
				match(NAME);
				setState(161);
				match(T__25);
				setState(162);
				match(T__3);
				setState(163);
				rp(0);
				}
				break;
			case 2:
				_localctx = new IndirectChildContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(DOC);
				setState(165);
				match(T__24);
				setState(166);
				match(NAME);
				setState(167);
				match(T__25);
				setState(168);
				match(T__4);
				setState(169);
				rp(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RpContext extends ParserRuleContext {
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
	 
		public RpContext() { }
		public void copyFrom(RpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AllContext extends RpContext {
		public AllContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class FilterContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public FilterContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class ParentContext extends RpContext {
		public ParentContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class CurrentContext extends RpContext {
		public CurrentContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class IndirectChildRPContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public IndirectChildRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class TextContext extends RpContext {
		public TextContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class ConcatContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public ConcatContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class TagNameContext extends RpContext {
		public TerminalNode NAME() { return getToken(XQueryParser.NAME, 0); }
		public TagNameContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class AttrContext extends RpContext {
		public TerminalNode NAME() { return getToken(XQueryParser.NAME, 0); }
		public AttrContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class ParenRPContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public ParenRPContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class DirectChildRPContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public DirectChildRPContext(RpContext ctx) { copyFrom(ctx); }
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				_localctx = new TagNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(173);
				match(NAME);
				}
				break;
			case T__26:
				{
				_localctx = new AllContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				match(T__26);
				}
				break;
			case T__27:
				{
				_localctx = new CurrentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175);
				match(T__27);
				}
				break;
			case T__28:
				{
				_localctx = new ParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176);
				match(T__28);
				}
				break;
			case T__29:
				{
				_localctx = new TextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				match(T__29);
				}
				break;
			case T__30:
				{
				_localctx = new AttrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				match(T__30);
				setState(179);
				match(NAME);
				}
				break;
			case T__0:
				{
				_localctx = new ParenRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				match(T__0);
				setState(181);
				rp(0);
				setState(182);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(202);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(200);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new DirectChildRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(186);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(187);
						match(T__3);
						setState(188);
						rp(5);
						}
						break;
					case 2:
						{
						_localctx = new IndirectChildRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(189);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(190);
						match(T__4);
						setState(191);
						rp(4);
						}
						break;
					case 3:
						{
						_localctx = new ConcatContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(192);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(193);
						match(T__2);
						setState(194);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new FilterContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(195);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(196);
						match(T__31);
						setState(197);
						f(0);
						setState(198);
						match(T__32);
						}
						break;
					}
					} 
				}
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FContext extends ParserRuleContext {
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
	 
		public FContext() { }
		public void copyFrom(FContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StrContext extends FContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode STR() { return getToken(XQueryParser.STR, 0); }
		public StrContext(FContext ctx) { copyFrom(ctx); }
	}
	public static class NotContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public NotContext(FContext ctx) { copyFrom(ctx); }
	}
	public static class OrContext extends FContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public OrContext(FContext ctx) { copyFrom(ctx); }
	}
	public static class Eq1Context extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public Eq1Context(FContext ctx) { copyFrom(ctx); }
	}
	public static class AndContext extends FContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public AndContext(FContext ctx) { copyFrom(ctx); }
	}
	public static class Eq2Context extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public Eq2Context(FContext ctx) { copyFrom(ctx); }
	}
	public static class RpFtContext extends FContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public RpFtContext(FContext ctx) { copyFrom(ctx); }
	}
	public static class IsContext extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public TerminalNode IS() { return getToken(XQueryParser.IS, 0); }
		public IsContext(FContext ctx) { copyFrom(ctx); }
	}
	public static class ParenFtContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public ParenFtContext(FContext ctx) { copyFrom(ctx); }
	}

	public final FContext f() throws RecognitionException {
		return f(0);
	}

	private FContext f(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FContext _localctx = new FContext(_ctx, _parentState);
		FContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_f, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new RpFtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(206);
				rp(0);
				}
				break;
			case 2:
				{
				_localctx = new Eq1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207);
				rp(0);
				setState(208);
				match(T__15);
				setState(209);
				rp(0);
				}
				break;
			case 3:
				{
				_localctx = new StrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				rp(0);
				setState(212);
				match(T__15);
				setState(213);
				match(STR);
				}
				break;
			case 4:
				{
				_localctx = new Eq2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215);
				rp(0);
				setState(216);
				match(T__16);
				setState(217);
				rp(0);
				}
				break;
			case 5:
				{
				_localctx = new IsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219);
				rp(0);
				setState(220);
				match(IS);
				setState(221);
				rp(0);
				}
				break;
			case 6:
				{
				_localctx = new ParenFtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223);
				match(T__0);
				setState(224);
				f(0);
				setState(225);
				match(T__1);
				}
				break;
			case 7:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				match(T__22);
				setState(228);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(237);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(231);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(232);
						match(T__20);
						setState(233);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(234);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(235);
						match(T__21);
						setState(236);
						f(3);
						}
						break;
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return xq_sempred((XqContext)_localctx, predIndex);
		case 5:
			return cond_sempred((CondContext)_localctx, predIndex);
		case 8:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 9:
			return f_sempred((FContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean xq_sempred(XqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u00f5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\5\2,\n\2\3\2\5\2/\n\2\3\2\3\2\3\2\3\2\3\2\5\2\66\n"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2A\n\2\f\2\16\2D\13\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3O\n\3\f\3\16\3R\13\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\7\4]\n\4\f\4\16\4`\13\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0083\n\7\f\7\16\7\u0086\13\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0091\n\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\7\7\u0099\n\7\f\7\16\7\u009c\13\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00ad\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\5\n\u00bb\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\7\n\u00cb\n\n\f\n\16\n\u00ce\13\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00e8\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\7\13\u00f0\n\13\f\13\16\13\u00f3\13\13\3\13\2\6\2\f\22\24\f"+
		"\2\4\6\b\n\f\16\20\22\24\2\2\2\u0113\2\65\3\2\2\2\4E\3\2\2\2\6S\3\2\2"+
		"\2\ba\3\2\2\2\nd\3\2\2\2\f\u0090\3\2\2\2\16\u009d\3\2\2\2\20\u00ac\3\2"+
		"\2\2\22\u00ba\3\2\2\2\24\u00e7\3\2\2\2\26\27\b\2\1\2\27\66\5\16\b\2\30"+
		"\66\7\'\2\2\31\66\5\20\t\2\32\33\7\3\2\2\33\34\5\2\2\2\34\35\7\4\2\2\35"+
		"\66\3\2\2\2\36\37\7\b\2\2\37 \7&\2\2 !\7\t\2\2!\"\7\n\2\2\"#\5\2\2\2#"+
		"$\7\13\2\2$%\7\b\2\2%&\7\6\2\2&\'\7&\2\2\'(\7\t\2\2(\66\3\2\2\2)+\5\4"+
		"\3\2*,\5\6\4\2+*\3\2\2\2+,\3\2\2\2,.\3\2\2\2-/\5\b\5\2.-\3\2\2\2./\3\2"+
		"\2\2/\60\3\2\2\2\60\61\5\n\6\2\61\66\3\2\2\2\62\63\5\6\4\2\63\64\5\2\2"+
		"\3\64\66\3\2\2\2\65\26\3\2\2\2\65\30\3\2\2\2\65\31\3\2\2\2\65\32\3\2\2"+
		"\2\65\36\3\2\2\2\65)\3\2\2\2\65\62\3\2\2\2\66B\3\2\2\2\678\f\b\2\289\7"+
		"\5\2\29A\5\2\2\t:;\f\7\2\2;<\7\6\2\2<A\5\22\n\2=>\f\6\2\2>?\7\7\2\2?A"+
		"\5\22\n\2@\67\3\2\2\2@:\3\2\2\2@=\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2"+
		"\2C\3\3\2\2\2DB\3\2\2\2EF\7\f\2\2FG\5\16\b\2GH\7\r\2\2HP\5\2\2\2IJ\7\5"+
		"\2\2JK\5\16\b\2KL\7\r\2\2LM\5\2\2\2MO\3\2\2\2NI\3\2\2\2OR\3\2\2\2PN\3"+
		"\2\2\2PQ\3\2\2\2Q\5\3\2\2\2RP\3\2\2\2ST\7\16\2\2TU\5\16\b\2UV\7\17\2\2"+
		"V^\5\2\2\2WX\7\5\2\2XY\5\16\b\2YZ\7\17\2\2Z[\5\2\2\2[]\3\2\2\2\\W\3\2"+
		"\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\7\3\2\2\2`^\3\2\2\2ab\7\20\2\2bc"+
		"\5\f\7\2c\t\3\2\2\2de\7\21\2\2ef\5\2\2\2f\13\3\2\2\2gh\b\7\1\2hi\5\2\2"+
		"\2ij\7\22\2\2jk\5\2\2\2k\u0091\3\2\2\2lm\5\2\2\2mn\7\23\2\2no\5\2\2\2"+
		"o\u0091\3\2\2\2pq\5\2\2\2qr\7%\2\2rs\5\2\2\2s\u0091\3\2\2\2tu\7\24\2\2"+
		"uv\7\3\2\2vw\5\2\2\2wx\7\4\2\2x\u0091\3\2\2\2yz\7\25\2\2z{\5\16\b\2{|"+
		"\7\r\2\2|\u0084\5\2\2\2}~\7\5\2\2~\177\5\16\b\2\177\u0080\7\r\2\2\u0080"+
		"\u0081\5\2\2\2\u0081\u0083\3\2\2\2\u0082}\3\2\2\2\u0083\u0086\3\2\2\2"+
		"\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084"+
		"\3\2\2\2\u0087\u0088\7\26\2\2\u0088\u0089\5\f\7\7\u0089\u0091\3\2\2\2"+
		"\u008a\u008b\7\3\2\2\u008b\u008c\5\f\7\2\u008c\u008d\7\4\2\2\u008d\u0091"+
		"\3\2\2\2\u008e\u008f\7\31\2\2\u008f\u0091\5\f\7\3\u0090g\3\2\2\2\u0090"+
		"l\3\2\2\2\u0090p\3\2\2\2\u0090t\3\2\2\2\u0090y\3\2\2\2\u0090\u008a\3\2"+
		"\2\2\u0090\u008e\3\2\2\2\u0091\u009a\3\2\2\2\u0092\u0093\f\5\2\2\u0093"+
		"\u0094\7\27\2\2\u0094\u0099\5\f\7\6\u0095\u0096\f\4\2\2\u0096\u0097\7"+
		"\30\2\2\u0097\u0099\5\f\7\5\u0098\u0092\3\2\2\2\u0098\u0095\3\2\2\2\u0099"+
		"\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\r\3\2\2\2"+
		"\u009c\u009a\3\2\2\2\u009d\u009e\7\32\2\2\u009e\u009f\7&\2\2\u009f\17"+
		"\3\2\2\2\u00a0\u00a1\7$\2\2\u00a1\u00a2\7\33\2\2\u00a2\u00a3\7&\2\2\u00a3"+
		"\u00a4\7\34\2\2\u00a4\u00a5\7\6\2\2\u00a5\u00ad\5\22\n\2\u00a6\u00a7\7"+
		"$\2\2\u00a7\u00a8\7\33\2\2\u00a8\u00a9\7&\2\2\u00a9\u00aa\7\34\2\2\u00aa"+
		"\u00ab\7\7\2\2\u00ab\u00ad\5\22\n\2\u00ac\u00a0\3\2\2\2\u00ac\u00a6\3"+
		"\2\2\2\u00ad\21\3\2\2\2\u00ae\u00af\b\n\1\2\u00af\u00bb\7&\2\2\u00b0\u00bb"+
		"\7\35\2\2\u00b1\u00bb\7\36\2\2\u00b2\u00bb\7\37\2\2\u00b3\u00bb\7 \2\2"+
		"\u00b4\u00b5\7!\2\2\u00b5\u00bb\7&\2\2\u00b6\u00b7\7\3\2\2\u00b7\u00b8"+
		"\5\22\n\2\u00b8\u00b9\7\4\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00ae\3\2\2\2"+
		"\u00ba\u00b0\3\2\2\2\u00ba\u00b1\3\2\2\2\u00ba\u00b2\3\2\2\2\u00ba\u00b3"+
		"\3\2\2\2\u00ba\u00b4\3\2\2\2\u00ba\u00b6\3\2\2\2\u00bb\u00cc\3\2\2\2\u00bc"+
		"\u00bd\f\6\2\2\u00bd\u00be\7\6\2\2\u00be\u00cb\5\22\n\7\u00bf\u00c0\f"+
		"\5\2\2\u00c0\u00c1\7\7\2\2\u00c1\u00cb\5\22\n\6\u00c2\u00c3\f\3\2\2\u00c3"+
		"\u00c4\7\5\2\2\u00c4\u00cb\5\22\n\4\u00c5\u00c6\f\4\2\2\u00c6\u00c7\7"+
		"\"\2\2\u00c7\u00c8\5\24\13\2\u00c8\u00c9\7#\2\2\u00c9\u00cb\3\2\2\2\u00ca"+
		"\u00bc\3\2\2\2\u00ca\u00bf\3\2\2\2\u00ca\u00c2\3\2\2\2\u00ca\u00c5\3\2"+
		"\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\23\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\b\13\1\2\u00d0\u00e8\5\22"+
		"\n\2\u00d1\u00d2\5\22\n\2\u00d2\u00d3\7\22\2\2\u00d3\u00d4\5\22\n\2\u00d4"+
		"\u00e8\3\2\2\2\u00d5\u00d6\5\22\n\2\u00d6\u00d7\7\22\2\2\u00d7\u00d8\7"+
		"\'\2\2\u00d8\u00e8\3\2\2\2\u00d9\u00da\5\22\n\2\u00da\u00db\7\23\2\2\u00db"+
		"\u00dc\5\22\n\2\u00dc\u00e8\3\2\2\2\u00dd\u00de\5\22\n\2\u00de\u00df\7"+
		"%\2\2\u00df\u00e0\5\22\n\2\u00e0\u00e8\3\2\2\2\u00e1\u00e2\7\3\2\2\u00e2"+
		"\u00e3\5\24\13\2\u00e3\u00e4\7\4\2\2\u00e4\u00e8\3\2\2\2\u00e5\u00e6\7"+
		"\31\2\2\u00e6\u00e8\5\24\13\3\u00e7\u00cf\3\2\2\2\u00e7\u00d1\3\2\2\2"+
		"\u00e7\u00d5\3\2\2\2\u00e7\u00d9\3\2\2\2\u00e7\u00dd\3\2\2\2\u00e7\u00e1"+
		"\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00f1\3\2\2\2\u00e9\u00ea\f\5\2\2\u00ea"+
		"\u00eb\7\27\2\2\u00eb\u00f0\5\24\13\6\u00ec\u00ed\f\4\2\2\u00ed\u00ee"+
		"\7\30\2\2\u00ee\u00f0\5\24\13\5\u00ef\u00e9\3\2\2\2\u00ef\u00ec\3\2\2"+
		"\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\25"+
		"\3\2\2\2\u00f3\u00f1\3\2\2\2\24+.\65@BP^\u0084\u0090\u0098\u009a\u00ac"+
		"\u00ba\u00ca\u00cc\u00e7\u00ef\u00f1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}