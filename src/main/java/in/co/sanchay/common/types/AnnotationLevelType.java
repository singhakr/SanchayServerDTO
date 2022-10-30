package in.co.sanchay.common.types;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;

public class AnnotationLevelType extends SanchayType implements Serializable {
    public final int ord;
    private static Vector types = new Vector();

    /** Creates a new instance of TaskType */
    protected AnnotationLevelType(String id, String pk) {
        super(id, pk);

        if (AnnotationLevelType.last() != null) {
            this.prev = AnnotationLevelType.last();
            AnnotationLevelType.last().next = this;
        }

        types.add(this);
        ord = types.size();
    }

    public static int size()
    {
        return types.size();
    }

    public static SanchayType first()
    {
        return (SanchayType) types.get(0);
    }

    public static SanchayType last()
    {
        if(types.size() > 0)
            return (SanchayType) types.get(types.size() - 1);

        return null;
    }

    public static SanchayType getType(int i)
    {
        if(i >=0 && i < types.size())
            return (SanchayType) types.get(i);

        return null;
    }

    public static Enumeration elements()
    {
        return new TypeEnumerator(AnnotationLevelType.first());
    }

    public static SanchayType findFromClassName(String className)
    {
        Enumeration enm = AnnotationLevelType.elements();
        return findFromClassName(enm, className);
    }

    public static SanchayType findFromId(String i)
    {
        Enumeration enm = AnnotationLevelType.elements();
        return findFromId(enm, i);
    }

    public static final AnnotationLevelType RAW_TEXT = new AnnotationLevelType("Raw Text", "sanchay.common.types");
    public static final AnnotationLevelType TOKENIZED_TEXT = new AnnotationLevelType("Tokenized Text", "sanchay.common.types");
    public static final AnnotationLevelType POS_TAGGED = new AnnotationLevelType("POS Tagged", "sanchay.common.types");
    public static final AnnotationLevelType MORPH_ANALYZED = new AnnotationLevelType("Morphologically Annotated", "sanchay.common.types");
    public static final AnnotationLevelType CHUNK_TAGGED = new AnnotationLevelType("Chunk Tagged", "sanchay.common.types");
    public static final AnnotationLevelType PS_TREE_ANNOTATED = new AnnotationLevelType("Phrase Structure Annotated", "sanchay.common.types");
    public static final AnnotationLevelType DEPENDENCY_ANNOTATED = new AnnotationLevelType("Dependency Annotated", "sanchay.common.types");
    public static final AnnotationLevelType ANAPHORA_ANNOTATED = new AnnotationLevelType("Anaphora Annotated", "sanchay.common.types");
    public static final AnnotationLevelType WORD_SENSE_TAGGED = new AnnotationLevelType("Word Sense Tagged", "sanchay.common.types");
    public static final AnnotationLevelType NAMED_ENTITY_TAGGED = new AnnotationLevelType("Named Entity Tagged", "sanchay.common.types");
    public static final AnnotationLevelType DISCOURSE_TAGGED = new AnnotationLevelType("Discourse Tagged", "sanchay.common.types");
}
