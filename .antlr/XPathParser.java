// Generated from /Users/zouhongyu/Desktop/CSE232B_XQueryEvaluator/XPath.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XPathParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, IS=21, NAME=22, STR=23, WS=24;
	public static final int
		RULE_ap = 0, RULE_rp = 1, RULE_f = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"ap", "rp", "f"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'doc(\"'", "'\")/'", "'\")//'", "'*'", "'.'", "'..'", "'text()'", 
			"'@'", "'('", "')'", "'/'", "'//'", "'['", "']'", "','", "'='", "'eq'", 
			"'and'", "'or'", "'not'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "IS", "NAME", "STR", 
			"WS"
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
	public String getGrammarFileName() { return "XPath.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XPathParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
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
		public TerminalNode NAME() { return getToken(XPathParser.NAME, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public DirectChildContext(ApContext ctx) { copyFrom(ctx); }
	}
	public static class IndirectChildContext extends ApContext {
		public TerminalNode NAME() { return getToken(XPathParser.NAME, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public IndirectChildContext(ApContext ctx) { copyFrom(ctx); }
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ap);
		try {
			setState(14);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new DirectChildContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(6);
				match(T__0);
				setState(7);
				match(NAME);
				setState(8);
				match(T__1);
				setState(9);
				rp(0);
				}
				break;
			case 2:
				_localctx = new IndirectChildContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(10);
				match(T__0);
				setState(11);
				match(NAME);
				setState(12);
				match(T__2);
				setState(13);
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
		public TerminalNode NAME() { return getToken(XPathParser.NAME, 0); }
		public TagNameContext(RpContext ctx) { copyFrom(ctx); }
	}
	public static class AttrContext extends RpContext {
		public TerminalNode NAME() { return getToken(XPathParser.NAME, 0); }
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
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				_localctx = new TagNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(17);
				match(NAME);
				}
				break;
			case T__3:
				{
				_localctx = new AllContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(18);
				match(T__3);
				}
				break;
			case T__4:
				{
				_localctx = new CurrentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(19);
				match(T__4);
				}
				break;
			case T__5:
				{
				_localctx = new ParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(20);
				match(T__5);
				}
				break;
			case T__6:
				{
				_localctx = new TextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(21);
				match(T__6);
				}
				break;
			case T__7:
				{
				_localctx = new AttrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				match(T__7);
				setState(23);
				match(NAME);
				}
				break;
			case T__8:
				{
				_localctx = new ParenRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(T__8);
				setState(25);
				rp(0);
				setState(26);
				match(T__9);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(46);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(44);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new DirectChildRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(30);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(31);
						match(T__10);
						setState(32);
						rp(5);
						}
						break;
					case 2:
						{
						_localctx = new IndirectChildRPContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(33);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(34);
						match(T__11);
						setState(35);
						rp(4);
						}
						break;
					case 3:
						{
						_localctx = new ConcatContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(36);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(37);
						match(T__14);
						setState(38);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new FilterContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(39);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(40);
						match(T__12);
						setState(41);
						f(0);
						setState(42);
						match(T__13);
						}
						break;
					}
					} 
				}
				setState(48);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		public TerminalNode STR() { return getToken(XPathParser.STR, 0); }
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
		public TerminalNode IS() { return getToken(XPathParser.IS, 0); }
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_f, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new RpFtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(50);
				rp(0);
				}
				break;
			case 2:
				{
				_localctx = new Eq1Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				rp(0);
				setState(52);
				match(T__15);
				setState(53);
				rp(0);
				}
				break;
			case 3:
				{
				_localctx = new StrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				rp(0);
				setState(56);
				match(T__15);
				setState(57);
				match(STR);
				}
				break;
			case 4:
				{
				_localctx = new Eq2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59);
				rp(0);
				setState(60);
				match(T__16);
				setState(61);
				rp(0);
				}
				break;
			case 5:
				{
				_localctx = new IsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				rp(0);
				setState(64);
				match(IS);
				setState(65);
				rp(0);
				}
				break;
			case 6:
				{
				_localctx = new ParenFtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
				match(T__8);
				setState(68);
				f(0);
				setState(69);
				match(T__9);
				}
				break;
			case 7:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				match(T__19);
				setState(72);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(83);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(81);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(75);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(76);
						match(T__17);
						setState(77);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(78);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(79);
						match(T__18);
						setState(80);
						f(3);
						}
						break;
					}
					} 
				}
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		case 1:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 2:
			return f_sempred((FContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 1);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32Y\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\21\n\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\37\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3/\n\3\f\3\16\3\62\13\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4L\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4T\n\4\f\4\16\4W\13\4"+
		"\3\4\2\4\4\6\5\2\4\6\2\2\2h\2\20\3\2\2\2\4\36\3\2\2\2\6K\3\2\2\2\b\t\7"+
		"\3\2\2\t\n\7\30\2\2\n\13\7\4\2\2\13\21\5\4\3\2\f\r\7\3\2\2\r\16\7\30\2"+
		"\2\16\17\7\5\2\2\17\21\5\4\3\2\20\b\3\2\2\2\20\f\3\2\2\2\21\3\3\2\2\2"+
		"\22\23\b\3\1\2\23\37\7\30\2\2\24\37\7\6\2\2\25\37\7\7\2\2\26\37\7\b\2"+
		"\2\27\37\7\t\2\2\30\31\7\n\2\2\31\37\7\30\2\2\32\33\7\13\2\2\33\34\5\4"+
		"\3\2\34\35\7\f\2\2\35\37\3\2\2\2\36\22\3\2\2\2\36\24\3\2\2\2\36\25\3\2"+
		"\2\2\36\26\3\2\2\2\36\27\3\2\2\2\36\30\3\2\2\2\36\32\3\2\2\2\37\60\3\2"+
		"\2\2 !\f\6\2\2!\"\7\r\2\2\"/\5\4\3\7#$\f\5\2\2$%\7\16\2\2%/\5\4\3\6&\'"+
		"\f\3\2\2\'(\7\21\2\2(/\5\4\3\4)*\f\4\2\2*+\7\17\2\2+,\5\6\4\2,-\7\20\2"+
		"\2-/\3\2\2\2. \3\2\2\2.#\3\2\2\2.&\3\2\2\2.)\3\2\2\2/\62\3\2\2\2\60.\3"+
		"\2\2\2\60\61\3\2\2\2\61\5\3\2\2\2\62\60\3\2\2\2\63\64\b\4\1\2\64L\5\4"+
		"\3\2\65\66\5\4\3\2\66\67\7\22\2\2\678\5\4\3\28L\3\2\2\29:\5\4\3\2:;\7"+
		"\22\2\2;<\7\31\2\2<L\3\2\2\2=>\5\4\3\2>?\7\23\2\2?@\5\4\3\2@L\3\2\2\2"+
		"AB\5\4\3\2BC\7\27\2\2CD\5\4\3\2DL\3\2\2\2EF\7\13\2\2FG\5\6\4\2GH\7\f\2"+
		"\2HL\3\2\2\2IJ\7\26\2\2JL\5\6\4\3K\63\3\2\2\2K\65\3\2\2\2K9\3\2\2\2K="+
		"\3\2\2\2KA\3\2\2\2KE\3\2\2\2KI\3\2\2\2LU\3\2\2\2MN\f\5\2\2NO\7\24\2\2"+
		"OT\5\6\4\6PQ\f\4\2\2QR\7\25\2\2RT\5\6\4\5SM\3\2\2\2SP\3\2\2\2TW\3\2\2"+
		"\2US\3\2\2\2UV\3\2\2\2V\7\3\2\2\2WU\3\2\2\2\t\20\36.\60KSU";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}