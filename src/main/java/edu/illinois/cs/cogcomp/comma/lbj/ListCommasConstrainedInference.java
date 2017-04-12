// Modifying this comment will cause the next execution of LBJava to overwrite this file.
// F1B88000000000000000D3C814A038034144FA23BC463DB0479E6AA8051C314883A686DFF129F5C541FEE5B28EE666ED3629C8CC49844B9A855ABC21A45A25C27842C1AEB0FCC030A7A8D1DA0EB83464CD356AD72B02ED62AD9A83F77C60CA9C6680754DD677D99BFF0FC62CB72D78AEBC97F8DE70C0FB3E2198000000

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
import java.util.*;


public class ListCommasConstrainedInference extends ILPInference
{
  public static Sentence findHead(Comma c)
  {
    return c.getSentence();
  }


  public ListCommasConstrainedInference() { }
  public ListCommasConstrainedInference(Sentence head)
  {
    super(head, new OJalgoHook());
    constraint = new ListCommasConstrainedInference$subjectto().makeConstraint(head);
  }

  public String getHeadType() { return "edu.illinois.cs.cogcomp.comma.datastructures.Sentence"; }
  public String[] getHeadFinderTypes()
  {
    return new String[]{ "edu.illinois.cs.cogcomp.comma.datastructures.Comma" };
  }

  public Normalizer getNormalizer(Learner c)
  {
    return new IdentityNormalizer();
  }
}

