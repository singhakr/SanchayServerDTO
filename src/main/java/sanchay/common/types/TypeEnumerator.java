package sanchay.common.types;

import java.util.Enumeration;

public class TypeEnumerator implements Enumeration {
    protected SanchayType curr;

    protected TypeEnumerator(SanchayType f)
    {
        curr = f;
    }

    public boolean hasMoreElements() {
        boolean ret = false;

        if(curr != null)
            ret = true;
        else
        {
            ret = false;
            curr = null;
        }

        return ret;
    }

    public Object nextElement() {
        SanchayType c = curr;
        curr = curr.next();
        return c;
    }
}
