package org.eclipse.imp.asl.parser.ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 98:  relationClosure ::= value +
 *</b>
 */
public class relationClosure0 extends ASTNode implements IrelationClosure
{
    private Ivalue _value;
    private ASTNodeToken _PLUS;

    public Ivalue getvalue() { return _value; }
    public ASTNodeToken getPLUS() { return _PLUS; }

    public relationClosure0(IToken leftIToken, IToken rightIToken,
                            Ivalue _value,
                            ASTNodeToken _PLUS)
    {
        super(leftIToken, rightIToken);

        this._value = _value;
        ((ASTNode) _value).setParent(this);
        this._PLUS = _PLUS;
        ((ASTNode) _PLUS).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_value);
        list.add(_PLUS);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        //
        // The super call test is not required for now because an Ast node
        // can only extend the root Ast, AstToken and AstList and none of
        // these nodes contain additional children.
        //
        // if (! super.equals(o)) return false;
        //
        if (! (o instanceof relationClosure0)) return false;
        relationClosure0 other = (relationClosure0) o;
        if (! _value.equals(other._value)) return false;
        if (! _PLUS.equals(other._PLUS)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = hash * 31 + (_value.hashCode());
        hash = hash * 31 + (_PLUS.hashCode());
        return hash;
    }

    public void accept(IAstVisitor v)
    {
        if (! v.preVisit(this)) return;
        enter((Visitor) v);
        v.postVisit(this);
    }

    public void enter(Visitor v)
    {
        boolean checkChildren = v.visit(this);
        if (checkChildren)
        {
            _value.accept(v);
            _PLUS.accept(v);
        }
        v.endVisit(this);
    }
}

