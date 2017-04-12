// Modifying this comment will cause the next execution of LBJava to overwrite this file.
// F1B88000000000000000B49CC2E4E2A4D29455558084C2A2E457B4D4C292D2A4D26D07ECFCDCD445846D450B1D5580ECC4AC9CCCB4F08C82A4448A0D109684DCB21C129000ED7159C185000000

package edu.illinois.cs.cogcomp.comma.lbj;

import edu.illinois.cs.cogcomp.comma.datastructures.Comma;
import edu.illinois.cs.cogcomp.comma.datastructures.CommaProperties;
import edu.illinois.cs.cogcomp.comma.datastructures.Sentence;
import edu.illinois.cs.cogcomp.comma.readers.CommaParser;
import edu.illinois.cs.cogcomp.comma.readers.PrettyCorpusReader;
import edu.illinois.cs.cogcomp.core.datastructures.textannotation.*;
import edu.illinois.cs.cogcomp.infer.ilp.OJalgoHook;
import edu.illinois.cs.cogcomp.lbjava.classify.*;
import edu.illinois.cs.cogcomp.lbjava.infer.*;
import edu.illinois.cs.cogcomp.lbjava.io.IOUtilities;
import edu.illinois.cs.cogcomp.lbjava.learn.*;
import edu.illinois.cs.cogcomp.lbjava.parse.*;
import java.util.ArrayList;
import java.util.List;


public class ParseFeatures extends Classifier
{
  private static final SiblingPhraseFeatures __SiblingPhraseFeatures = new SiblingPhraseFeatures();
  private static final ParentSiblingPhraseFeatures __ParentSiblingPhraseFeatures = new ParentSiblingPhraseFeatures();

  public ParseFeatures()
  {
    containingPackage = "edu.illinois.cs.cogcomp.comma.lbj";
    name = "ParseFeatures";
  }

  public String getInputType() { return "edu.illinois.cs.cogcomp.comma.datastructures.Comma"; }
  public String getOutputType() { return "discrete%"; }

  public FeatureVector classify(Object __example)
  {
    if (!(__example instanceof Comma))
    {
      String type = __example == null ? "null" : __example.getClass().getName();
      System.err.println("Classifier 'ParseFeatures(Comma)' defined on line 178 of CommaClassifier.lbj received '" + type + "' as input.");
      new Exception().printStackTrace();
      System.exit(1);
    }

    FeatureVector __result;
    __result = new FeatureVector();
    __result.addFeatures(__SiblingPhraseFeatures.classify(__example));
    __result.addFeatures(__ParentSiblingPhraseFeatures.classify(__example));
    return __result;
  }

  public FeatureVector[] classify(Object[] examples)
  {
    if (!(examples instanceof Comma[]))
    {
      String type = examples == null ? "null" : examples.getClass().getName();
      System.err.println("Classifier 'ParseFeatures(Comma)' defined on line 178 of CommaClassifier.lbj received '" + type + "' as input.");
      new Exception().printStackTrace();
      System.exit(1);
    }

    return super.classify(examples);
  }

  public int hashCode() { return "ParseFeatures".hashCode(); }
  public boolean equals(Object o) { return o instanceof ParseFeatures; }

  public java.util.LinkedList getCompositeChildren()
  {
    java.util.LinkedList result = new java.util.LinkedList();
    result.add(__SiblingPhraseFeatures);
    result.add(__ParentSiblingPhraseFeatures);
    return result;
  }
}

