package com.vulpuslabs.spree;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.vulpes.modules.spree.*;
import com.vulpuslabs.vulpes.values.api.IndexedDoubleSupplier;
import com.vulpuslabs.vulpes.values.ranges.Range;
import com.vulpuslabs.vulpes.values.events.NotificationReceiver;
import com.vulpuslabs.vulpes.values.inputs.CvModulatableKnob;
import java.text.NumberFormat;
import java.text.DecimalFormat;

//[/user-imports]


public class Spree extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

   public Spree( long moduleID, VoltageObjects voltageObjects )
   {
      super( moduleID, voltageObjects, "Spree", ModuleType.ModuleType_Effect, 1.6 );

      InitializeControls();


      canBeBypassed = false;
      SetSkin( "98fb913822c24a4aa78b18efec9733f6" );
   }

void InitializeControls()
{

      inputJack = new VoltagePolyJack( "inputJack", "Input Jack", this, JackType.JackType_PolyInput );
      AddComponent( inputJack );
      inputJack.SetWantsMouseNotifications( false );
      inputJack.SetPosition( 12, 22 );
      inputJack.SetSize( 25, 25 );
      inputJack.SetSkin( "Poly Jack Straight" );

      outputJack = new VoltagePolyJack( "outputJack", "Output Jack", this, JackType.JackType_PolyOutput );
      AddComponent( outputJack );
      outputJack.SetWantsMouseNotifications( false );
      outputJack.SetPosition( 77, 22 );
      outputJack.SetSize( 25, 25 );
      outputJack.SetSkin( "Poly Jack Straight" );

      timeKnob = new VoltageKnob( "timeKnob", "Time", this, 4, 50, 4 );
      AddComponent( timeKnob );
      timeKnob.SetWantsMouseNotifications( false );
      timeKnob.SetPosition( 77, 73 );
      timeKnob.SetSize( 25, 25 );
      timeKnob.SetSkin( "SEM Large" );
      timeKnob.SetRange( 4, 50, 4, false, 0 );
      timeKnob.SetKnobParams( 215, 145 );
      timeKnob.SetUnits( "ms" );
      timeKnob.DisplayValueInPercent( false );
      timeKnob.SetKnobAdjustsRing( true );

      depthKnob = new VoltageKnob( "depthKnob", "Depth", this, 0.0, 1.0, 0.5 );
      AddComponent( depthKnob );
      depthKnob.SetWantsMouseNotifications( false );
      depthKnob.SetPosition( 77, 119 );
      depthKnob.SetSize( 25, 25 );
      depthKnob.SetSkin( "SEM Large" );
      depthKnob.SetRange( 0.0, 1.0, 0.5, false, 0 );
      depthKnob.SetKnobParams( 215, 145 );
      depthKnob.DisplayValueInPercent( true );
      depthKnob.SetKnobAdjustsRing( false );

      speedKnob = new VoltageKnob( "speedKnob", "Speed", this, 1, 8.0, 3.0 );
      AddComponent( speedKnob );
      speedKnob.SetWantsMouseNotifications( false );
      speedKnob.SetPosition( 77, 165 );
      speedKnob.SetSize( 25, 25 );
      speedKnob.SetSkin( "SEM Large" );
      speedKnob.SetRange( 1, 8.0, 3.0, false, 0 );
      speedKnob.SetKnobParams( 215, 145 );
      speedKnob.DisplayValueInPercent( false );
      speedKnob.SetKnobAdjustsRing( false );

      mixKnob = new VoltageKnob( "mixKnob", "Mix", this, 0.0, 1.0, 0.3 );
      AddComponent( mixKnob );
      mixKnob.SetWantsMouseNotifications( false );
      mixKnob.SetPosition( 77, 257 );
      mixKnob.SetSize( 25, 25 );
      mixKnob.SetSkin( "SEM Large" );
      mixKnob.SetRange( 0.0, 1.0, 0.3, false, 0 );
      mixKnob.SetKnobParams( 215, 145 );
      mixKnob.SetUnits( "wet" );
      mixKnob.DisplayValueInPercent( true );
      mixKnob.SetKnobAdjustsRing( true );

      depthControl = new VoltageAudioJack( "depthControl", "Depth Control", this, JackType.JackType_AudioInput );
      AddComponent( depthControl );
      depthControl.SetWantsMouseNotifications( false );
      depthControl.SetPosition( 12, 119 );
      depthControl.SetSize( 25, 25 );
      depthControl.SetSkin( "Mini Jack 25px" );

      speedControl = new VoltageAudioJack( "speedControl", "Speed Control", this, JackType.JackType_AudioInput );
      AddComponent( speedControl );
      speedControl.SetWantsMouseNotifications( false );
      speedControl.SetPosition( 12, 165 );
      speedControl.SetSize( 25, 25 );
      speedControl.SetSkin( "Mini Jack 25px" );

      mixControl = new VoltageAudioJack( "mixControl", "Mix Control", this, JackType.JackType_AudioInput );
      AddComponent( mixControl );
      mixControl.SetWantsMouseNotifications( false );
      mixControl.SetPosition( 12, 257 );
      mixControl.SetSize( 25, 25 );
      mixControl.SetSkin( "Mini Jack 25px" );

      feedbackKnob = new VoltageKnob( "feedbackKnob", "Feedback", this, 0.0, 0.99, 0.0 );
      AddComponent( feedbackKnob );
      feedbackKnob.SetWantsMouseNotifications( false );
      feedbackKnob.SetPosition( 77, 211 );
      feedbackKnob.SetSize( 25, 25 );
      feedbackKnob.SetSkin( "SEM Large" );
      feedbackKnob.SetRange( 0.0, 0.99, 0.0, false, 0 );
      feedbackKnob.SetKnobParams( 215, 145 );
      feedbackKnob.DisplayValueInPercent( true );
      feedbackKnob.SetKnobAdjustsRing( false );

      feedbackControl = new VoltageAudioJack( "feedbackControl", "Feedback Control", this, JackType.JackType_AudioInput );
      AddComponent( feedbackControl );
      feedbackControl.SetWantsMouseNotifications( false );
      feedbackControl.SetPosition( 12, 211 );
      feedbackControl.SetSize( 25, 25 );
      feedbackControl.SetSkin( "Mini Jack 25px" );

      textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "VULPUS LABS" );
      AddComponent( textLabel1 );
      textLabel1.SetWantsMouseNotifications( false );
      textLabel1.SetPosition( 0, 340 );
      textLabel1.SetSize( 115, 20 );
      textLabel1.SetEditable( false, false );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel1.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel1.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel1.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel1.SetBorderSize( 1 );
      textLabel1.SetMultiLineEdit( false );
      textLabel1.SetIsNumberEditor( false );
      textLabel1.SetNumberEditorRange( 0, 100 );
      textLabel1.SetNumberEditorInterval( 1 );
      textLabel1.SetNumberEditorUsesMouseWheel( false );
      textLabel1.SetHasCustomTextHoverColor( false );
      textLabel1.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel1.SetFont( "<Sans-Serif>", 10, true, false );

      textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "MIX" );
      AddComponent( textLabel2 );
      textLabel2.SetWantsMouseNotifications( false );
      textLabel2.SetPosition( 7, 282 );
      textLabel2.SetSize( 100, 18 );
      textLabel2.SetEditable( false, false );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel2.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel2.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel2.SetBorderSize( 1 );
      textLabel2.SetMultiLineEdit( false );
      textLabel2.SetIsNumberEditor( false );
      textLabel2.SetNumberEditorRange( 0, 100 );
      textLabel2.SetNumberEditorInterval( 1 );
      textLabel2.SetNumberEditorUsesMouseWheel( false );
      textLabel2.SetHasCustomTextHoverColor( false );
      textLabel2.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel2.SetFont( "<Sans-Serif>", 10, true, false );

      textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "SPREAD" );
      AddComponent( textLabel10 );
      textLabel10.SetWantsMouseNotifications( false );
      textLabel10.SetPosition( 0, 301 );
      textLabel10.SetSize( 57, 20 );
      textLabel10.SetEditable( false, false );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel10.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel10.SetBorderSize( 1 );
      textLabel10.SetMultiLineEdit( false );
      textLabel10.SetIsNumberEditor( false );
      textLabel10.SetNumberEditorRange( 0, 100 );
      textLabel10.SetNumberEditorInterval( 1 );
      textLabel10.SetNumberEditorUsesMouseWheel( false );
      textLabel10.SetHasCustomTextHoverColor( false );
      textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel10.SetFont( "<Sans-Serif>", 10, true, false );

      textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "-" );
      AddComponent( textLabel11 );
      textLabel11.SetWantsMouseNotifications( false );
      textLabel11.SetPosition( 37, 271 );
      textLabel11.SetSize( 15, 13 );
      textLabel11.SetEditable( false, false );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel11.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel11.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel11.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel11.SetBorderSize( 1 );
      textLabel11.SetMultiLineEdit( false );
      textLabel11.SetIsNumberEditor( false );
      textLabel11.SetNumberEditorRange( 0, 100 );
      textLabel11.SetNumberEditorInterval( 1 );
      textLabel11.SetNumberEditorUsesMouseWheel( false );
      textLabel11.SetHasCustomTextHoverColor( false );
      textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel11.SetFont( "<Sans-Serif>", 8, true, false );

      textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "+" );
      AddComponent( textLabel12 );
      textLabel12.SetWantsMouseNotifications( false );
      textLabel12.SetPosition( 62, 271 );
      textLabel12.SetSize( 15, 13 );
      textLabel12.SetEditable( false, false );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel12.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel12.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel12.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel12.SetBorderSize( 1 );
      textLabel12.SetMultiLineEdit( false );
      textLabel12.SetIsNumberEditor( false );
      textLabel12.SetNumberEditorRange( 0, 100 );
      textLabel12.SetNumberEditorInterval( 1 );
      textLabel12.SetNumberEditorUsesMouseWheel( false );
      textLabel12.SetHasCustomTextHoverColor( false );
      textLabel12.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel12.SetFont( "<Sans-Serif>", 8, true, false );

      textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "+" );
      AddComponent( textLabel13 );
      textLabel13.SetWantsMouseNotifications( false );
      textLabel13.SetPosition( 62, 226 );
      textLabel13.SetSize( 15, 13 );
      textLabel13.SetEditable( false, false );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel13.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel13.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel13.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel13.SetBorderSize( 1 );
      textLabel13.SetMultiLineEdit( false );
      textLabel13.SetIsNumberEditor( false );
      textLabel13.SetNumberEditorRange( 0, 100 );
      textLabel13.SetNumberEditorInterval( 1 );
      textLabel13.SetNumberEditorUsesMouseWheel( false );
      textLabel13.SetHasCustomTextHoverColor( false );
      textLabel13.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel13.SetFont( "<Sans-Serif>", 8, true, false );

      textLabel14 = new VoltageLabel( "textLabel14", "textLabel14", this, "-" );
      AddComponent( textLabel14 );
      textLabel14.SetWantsMouseNotifications( false );
      textLabel14.SetPosition( 37, 226 );
      textLabel14.SetSize( 15, 13 );
      textLabel14.SetEditable( false, false );
      textLabel14.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel14.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel14.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel14.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel14.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel14.SetBorderSize( 1 );
      textLabel14.SetMultiLineEdit( false );
      textLabel14.SetIsNumberEditor( false );
      textLabel14.SetNumberEditorRange( 0, 100 );
      textLabel14.SetNumberEditorInterval( 1 );
      textLabel14.SetNumberEditorUsesMouseWheel( false );
      textLabel14.SetHasCustomTextHoverColor( false );
      textLabel14.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel14.SetFont( "<Sans-Serif>", 8, true, false );

      textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "+" );
      AddComponent( textLabel15 );
      textLabel15.SetWantsMouseNotifications( false );
      textLabel15.SetPosition( 62, 178 );
      textLabel15.SetSize( 15, 13 );
      textLabel15.SetEditable( false, false );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel15.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel15.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel15.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel15.SetBorderSize( 1 );
      textLabel15.SetMultiLineEdit( false );
      textLabel15.SetIsNumberEditor( false );
      textLabel15.SetNumberEditorRange( 0, 100 );
      textLabel15.SetNumberEditorInterval( 1 );
      textLabel15.SetNumberEditorUsesMouseWheel( false );
      textLabel15.SetHasCustomTextHoverColor( false );
      textLabel15.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel15.SetFont( "<Sans-Serif>", 8, true, false );

      textLabel16 = new VoltageLabel( "textLabel16", "textLabel16", this, "-" );
      AddComponent( textLabel16 );
      textLabel16.SetWantsMouseNotifications( false );
      textLabel16.SetPosition( 37, 177 );
      textLabel16.SetSize( 15, 13 );
      textLabel16.SetEditable( false, false );
      textLabel16.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel16.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel16.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel16.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel16.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel16.SetBorderSize( 1 );
      textLabel16.SetMultiLineEdit( false );
      textLabel16.SetIsNumberEditor( false );
      textLabel16.SetNumberEditorRange( 0, 100 );
      textLabel16.SetNumberEditorInterval( 1 );
      textLabel16.SetNumberEditorUsesMouseWheel( false );
      textLabel16.SetHasCustomTextHoverColor( false );
      textLabel16.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel16.SetFont( "<Sans-Serif>", 8, true, false );

      textLabel17 = new VoltageLabel( "textLabel17", "textLabel17", this, "+" );
      AddComponent( textLabel17 );
      textLabel17.SetWantsMouseNotifications( false );
      textLabel17.SetPosition( 62, 133 );
      textLabel17.SetSize( 15, 13 );
      textLabel17.SetEditable( false, false );
      textLabel17.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel17.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel17.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel17.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel17.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel17.SetBorderSize( 1 );
      textLabel17.SetMultiLineEdit( false );
      textLabel17.SetIsNumberEditor( false );
      textLabel17.SetNumberEditorRange( 0, 100 );
      textLabel17.SetNumberEditorInterval( 1 );
      textLabel17.SetNumberEditorUsesMouseWheel( false );
      textLabel17.SetHasCustomTextHoverColor( false );
      textLabel17.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel17.SetFont( "<Sans-Serif>", 8, true, false );

      textLabel18 = new VoltageLabel( "textLabel18", "textLabel18", this, "-" );
      AddComponent( textLabel18 );
      textLabel18.SetWantsMouseNotifications( false );
      textLabel18.SetPosition( 37, 133 );
      textLabel18.SetSize( 15, 13 );
      textLabel18.SetEditable( false, false );
      textLabel18.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel18.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel18.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel18.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel18.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel18.SetBorderSize( 1 );
      textLabel18.SetMultiLineEdit( false );
      textLabel18.SetIsNumberEditor( false );
      textLabel18.SetNumberEditorRange( 0, 100 );
      textLabel18.SetNumberEditorInterval( 1 );
      textLabel18.SetNumberEditorUsesMouseWheel( false );
      textLabel18.SetHasCustomTextHoverColor( false );
      textLabel18.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel18.SetFont( "<Sans-Serif>", 8, true, false );

      textLabel19 = new VoltageLabel( "textLabel19", "textLabel19", this, "+" );
      AddComponent( textLabel19 );
      textLabel19.SetWantsMouseNotifications( false );
      textLabel19.SetPosition( 62, 86 );
      textLabel19.SetSize( 15, 13 );
      textLabel19.SetEditable( false, false );
      textLabel19.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel19.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel19.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel19.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel19.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel19.SetBorderSize( 1 );
      textLabel19.SetMultiLineEdit( false );
      textLabel19.SetIsNumberEditor( false );
      textLabel19.SetNumberEditorRange( 0, 100 );
      textLabel19.SetNumberEditorInterval( 1 );
      textLabel19.SetNumberEditorUsesMouseWheel( false );
      textLabel19.SetHasCustomTextHoverColor( false );
      textLabel19.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel19.SetFont( "<Sans-Serif>", 8, true, false );

      textLabel20 = new VoltageLabel( "textLabel20", "textLabel20", this, "-" );
      AddComponent( textLabel20 );
      textLabel20.SetWantsMouseNotifications( false );
      textLabel20.SetPosition( 37, 86 );
      textLabel20.SetSize( 15, 13 );
      textLabel20.SetEditable( false, false );
      textLabel20.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel20.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel20.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel20.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel20.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel20.SetBorderSize( 1 );
      textLabel20.SetMultiLineEdit( false );
      textLabel20.SetIsNumberEditor( false );
      textLabel20.SetNumberEditorRange( 0, 100 );
      textLabel20.SetNumberEditorInterval( 1 );
      textLabel20.SetNumberEditorUsesMouseWheel( false );
      textLabel20.SetHasCustomTextHoverColor( false );
      textLabel20.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel20.SetFont( "<Sans-Serif>", 8, true, false );

      textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "FBCK" );
      AddComponent( textLabel3 );
      textLabel3.SetWantsMouseNotifications( false );
      textLabel3.SetPosition( 7, 236 );
      textLabel3.SetSize( 100, 18 );
      textLabel3.SetEditable( false, false );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel3.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel3.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel3.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel3.SetBorderSize( 1 );
      textLabel3.SetMultiLineEdit( false );
      textLabel3.SetIsNumberEditor( false );
      textLabel3.SetNumberEditorRange( 0, 100 );
      textLabel3.SetNumberEditorInterval( 1 );
      textLabel3.SetNumberEditorUsesMouseWheel( false );
      textLabel3.SetHasCustomTextHoverColor( false );
      textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel3.SetFont( "<Sans-Serif>", 10, true, false );

      textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "SPEED" );
      AddComponent( textLabel4 );
      textLabel4.SetWantsMouseNotifications( false );
      textLabel4.SetPosition( 7, 190 );
      textLabel4.SetSize( 100, 18 );
      textLabel4.SetEditable( false, false );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel4.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel4.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel4.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel4.SetBorderSize( 1 );
      textLabel4.SetMultiLineEdit( false );
      textLabel4.SetIsNumberEditor( false );
      textLabel4.SetNumberEditorRange( 0, 100 );
      textLabel4.SetNumberEditorInterval( 1 );
      textLabel4.SetNumberEditorUsesMouseWheel( false );
      textLabel4.SetHasCustomTextHoverColor( false );
      textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel4.SetFont( "<Sans-Serif>", 10, true, false );

      textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "TIME" );
      AddComponent( textLabel6 );
      textLabel6.SetWantsMouseNotifications( false );
      textLabel6.SetPosition( 7, 98 );
      textLabel6.SetSize( 100, 18 );
      textLabel6.SetEditable( false, false );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel6.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel6.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel6.SetBorderSize( 1 );
      textLabel6.SetMultiLineEdit( false );
      textLabel6.SetIsNumberEditor( false );
      textLabel6.SetNumberEditorRange( 0, 100 );
      textLabel6.SetNumberEditorInterval( 1 );
      textLabel6.SetNumberEditorUsesMouseWheel( false );
      textLabel6.SetHasCustomTextHoverColor( false );
      textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel6.SetFont( "<Sans-Serif>", 10, true, false );

      textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "DEPTH" );
      AddComponent( textLabel5 );
      textLabel5.SetWantsMouseNotifications( false );
      textLabel5.SetPosition( 7, 144 );
      textLabel5.SetSize( 100, 20 );
      textLabel5.SetEditable( false, false );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel5.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel5.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel5.SetBorderSize( 1 );
      textLabel5.SetMultiLineEdit( false );
      textLabel5.SetIsNumberEditor( false );
      textLabel5.SetNumberEditorRange( 0, 100 );
      textLabel5.SetNumberEditorInterval( 1 );
      textLabel5.SetNumberEditorUsesMouseWheel( false );
      textLabel5.SetHasCustomTextHoverColor( false );
      textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel5.SetFont( "<Sans-Serif>", 10, true, false );

      textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "SPREE" );
      AddComponent( textLabel7 );
      textLabel7.SetWantsMouseNotifications( false );
      textLabel7.SetPosition( 0, 0 );
      textLabel7.SetSize( 115, 20 );
      textLabel7.SetEditable( false, false );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel7.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel7.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel7.SetBorderSize( 1 );
      textLabel7.SetMultiLineEdit( false );
      textLabel7.SetIsNumberEditor( false );
      textLabel7.SetNumberEditorRange( 0, 100 );
      textLabel7.SetNumberEditorInterval( 1 );
      textLabel7.SetNumberEditorUsesMouseWheel( false );
      textLabel7.SetHasCustomTextHoverColor( false );
      textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel7.SetFont( "<Sans-Serif>", 10, true, false );

      textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "IN" );
      AddComponent( textLabel8 );
      textLabel8.SetWantsMouseNotifications( false );
      textLabel8.SetPosition( 7, 48 );
      textLabel8.SetSize( 36, 20 );
      textLabel8.SetEditable( false, false );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel8.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel8.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel8.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel8.SetBorderSize( 1 );
      textLabel8.SetMultiLineEdit( false );
      textLabel8.SetIsNumberEditor( false );
      textLabel8.SetNumberEditorRange( 0, 100 );
      textLabel8.SetNumberEditorInterval( 1 );
      textLabel8.SetNumberEditorUsesMouseWheel( false );
      textLabel8.SetHasCustomTextHoverColor( false );
      textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel8.SetFont( "<Sans-Serif>", 10, true, false );

      textLabel21 = new VoltageLabel( "textLabel21", "textLabel21", this, "SIN" );
      AddComponent( textLabel21 );
      textLabel21.SetWantsMouseNotifications( false );
      textLabel21.SetPosition( 46, 49 );
      textLabel21.SetSize( 36, 20 );
      textLabel21.SetEditable( false, false );
      textLabel21.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel21.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel21.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel21.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel21.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel21.SetBorderSize( 1 );
      textLabel21.SetMultiLineEdit( false );
      textLabel21.SetIsNumberEditor( false );
      textLabel21.SetNumberEditorRange( 0, 100 );
      textLabel21.SetNumberEditorInterval( 1 );
      textLabel21.SetNumberEditorUsesMouseWheel( false );
      textLabel21.SetHasCustomTextHoverColor( false );
      textLabel21.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel21.SetFont( "Arial", 8, true, false );

      textLabel22 = new VoltageLabel( "textLabel22", "textLabel22", this, "TRI" );
      AddComponent( textLabel22 );
      textLabel22.SetWantsMouseNotifications( false );
      textLabel22.SetPosition( 46, 32 );
      textLabel22.SetSize( 36, 20 );
      textLabel22.SetEditable( false, false );
      textLabel22.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel22.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel22.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel22.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel22.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel22.SetBorderSize( 1 );
      textLabel22.SetMultiLineEdit( false );
      textLabel22.SetIsNumberEditor( false );
      textLabel22.SetNumberEditorRange( 0, 100 );
      textLabel22.SetNumberEditorInterval( 1 );
      textLabel22.SetNumberEditorUsesMouseWheel( false );
      textLabel22.SetHasCustomTextHoverColor( false );
      textLabel22.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel22.SetFont( "Arial", 8, true, false );

      textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "OUT" );
      AddComponent( textLabel9 );
      textLabel9.SetWantsMouseNotifications( false );
      textLabel9.SetPosition( 68, 48 );
      textLabel9.SetSize( 43, 20 );
      textLabel9.SetEditable( false, false );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel9.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel9.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel9.SetBorderSize( 1 );
      textLabel9.SetMultiLineEdit( false );
      textLabel9.SetIsNumberEditor( false );
      textLabel9.SetNumberEditorRange( 0, 100 );
      textLabel9.SetNumberEditorInterval( 1 );
      textLabel9.SetNumberEditorUsesMouseWheel( false );
      textLabel9.SetHasCustomTextHoverColor( false );
      textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel9.SetFont( "<Sans-Serif>", 10, true, false );

      rangeSwitch = new VoltageSwitch( "rangeSwitch", "Range Switch", this, 1 );
      AddComponent( rangeSwitch );
      rangeSwitch.SetWantsMouseNotifications( false );
      rangeSwitch.SetPosition( 15, 194 );
      rangeSwitch.SetSize( 20, 11 );
      rangeSwitch.SetSkin( "2-State Slide Horizontal" );

      waveformSwitch = new VoltageSwitch( "waveformSwitch", "Waveform Switch", this, 1 );
      AddComponent( waveformSwitch );
      waveformSwitch.SetWantsMouseNotifications( false );
      waveformSwitch.SetPosition( 43, 39 );
      waveformSwitch.SetSize( 12, 21 );
      waveformSwitch.SetSkin( "2-State Slide Vertical" );

      timeControl = new VoltageAudioJack( "timeControl", "Time Control", this, JackType.JackType_AudioInput );
      AddComponent( timeControl );
      timeControl.SetWantsMouseNotifications( false );
      timeControl.SetPosition( 12, 73 );
      timeControl.SetSize( 25, 25 );
      timeControl.SetSkin( "Mini Jack 25px" );

      spreadSlider = new VoltageSlider( "spreadSlider", "Spread", this, false, 0.0, 1.0, 0.5, 0 );
      AddComponent( spreadSlider );
      spreadSlider.SetWantsMouseNotifications( false );
      spreadSlider.SetPosition( 57, 303 );
      spreadSlider.SetSize( 57, 15 );
      spreadSlider.SetSkin( "Straight Black Plain Horizontal" );
      spreadSlider.DisplayValueInPercent( true );

      timeCvAmount = new VoltageKnob( "timeCvAmount", "Time CV Amount", this, -1.0, 1.0, 0.0 );
      AddComponent( timeCvAmount );
      timeCvAmount.SetWantsMouseNotifications( false );
      timeCvAmount.SetPosition( 47, 75 );
      timeCvAmount.SetSize( 20, 20 );
      timeCvAmount.SetSkin( "ARP2500 Sm Blue" );
      timeCvAmount.SetRange( -1.0, 1.0, 0.0, false, 0 );
      timeCvAmount.SetKnobParams( 215, 145 );
      timeCvAmount.DisplayValueInPercent( true );
      timeCvAmount.SetKnobAdjustsRing( true );

      depthCvAmount = new VoltageKnob( "depthCvAmount", "Depth CV Amount", this, -1.0, 1.0, 0.0 );
      AddComponent( depthCvAmount );
      depthCvAmount.SetWantsMouseNotifications( false );
      depthCvAmount.SetPosition( 47, 122 );
      depthCvAmount.SetSize( 20, 20 );
      depthCvAmount.SetSkin( "ARP2500 Sm Blue" );
      depthCvAmount.SetRange( -1.0, 1.0, 0.0, false, 0 );
      depthCvAmount.SetKnobParams( 215, 145 );
      depthCvAmount.DisplayValueInPercent( true );
      depthCvAmount.SetKnobAdjustsRing( true );

      speedCvAmount = new VoltageKnob( "speedCvAmount", "Speed CV Amount", this, -1.0, 1.0, 0.0 );
      AddComponent( speedCvAmount );
      speedCvAmount.SetWantsMouseNotifications( false );
      speedCvAmount.SetPosition( 47, 167 );
      speedCvAmount.SetSize( 20, 20 );
      speedCvAmount.SetSkin( "ARP2500 Sm Blue" );
      speedCvAmount.SetRange( -1.0, 1.0, 0.0, false, 0 );
      speedCvAmount.SetKnobParams( 215, 145 );
      speedCvAmount.DisplayValueInPercent( true );
      speedCvAmount.SetKnobAdjustsRing( true );

      feedbackCvAmount = new VoltageKnob( "feedbackCvAmount", "Feedback CV Amount", this, -1.0, 1.0, 0.0 );
      AddComponent( feedbackCvAmount );
      feedbackCvAmount.SetWantsMouseNotifications( false );
      feedbackCvAmount.SetPosition( 47, 215 );
      feedbackCvAmount.SetSize( 20, 20 );
      feedbackCvAmount.SetSkin( "ARP2500 Sm Blue" );
      feedbackCvAmount.SetRange( -1.0, 1.0, 0.0, false, 0 );
      feedbackCvAmount.SetKnobParams( 215, 145 );
      feedbackCvAmount.DisplayValueInPercent( true );
      feedbackCvAmount.SetKnobAdjustsRing( true );

      mixCvAmount = new VoltageKnob( "mixCvAmount", "Mix CV Amount", this, -1.0, 1.0, 0.0 );
      AddComponent( mixCvAmount );
      mixCvAmount.SetWantsMouseNotifications( false );
      mixCvAmount.SetPosition( 47, 260 );
      mixCvAmount.SetSize( 20, 20 );
      mixCvAmount.SetSkin( "ARP2500 Sm Blue" );
      mixCvAmount.SetRange( -1.0, 1.0, 0.0, false, 0 );
      mixCvAmount.SetKnobParams( 215, 145 );
      mixCvAmount.DisplayValueInPercent( true );
      mixCvAmount.SetKnobAdjustsRing( true );
}



   //-------------------------------------------------------------------------------
   //  public void Initialize()

      //  Initialize will get called shortly after your module's constructor runs. You can use it to
      //  do any initialization that the auto-generated code doesn't handle.
   //-------------------------------------------------------------------------------
   @Override
   public void Initialize()
   {
      //[user-Initialize]   Add your own initialization code here
      inputBus = new InputBus(
         inputJack::GetPolyValue,
         makeModulatable(timeKnob, timeCvAmount, timeControl),
         makeModulatable(depthKnob, depthCvAmount, depthControl),
         makeModulatable(speedKnob, speedCvAmount, speedControl),
         makeModulatable(feedbackKnob, feedbackCvAmount, feedbackControl),
         makeModulatable(mixKnob, mixCvAmount, mixControl)
      );
         
      controller = new Controller(
         inputBus,
         outputJack::SetPolyValue,
         GetNumberOfPolyVoices(),
         spreadSlider.GetValue(),
         waveformSwitch.GetValue() == 1.0);
      //[/user-Initialize]
   }


   //-------------------------------------------------------------------------------
   //  public void Destroy()

      //  Destroy will get called just before your module gets deleted. You can use it to perform any
      //  cleanup that's not handled automatically by Java.
   //-------------------------------------------------------------------------------
   @Override
   public void Destroy()
   {
      super.Destroy();
      //[user-Destroy]   Add your own module-getting-deleted code here



      //[/user-Destroy]
   }


   //-------------------------------------------------------------------------------
   //  public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )

      //  Notify will get called when various events occur - control values changing, timers firing, etc.
   //-------------------------------------------------------------------------------
   @Override
   public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )
   {
      //[user-Notify]   Add your own notification handling code between this line and the notify-close comment
      switch( notification )
      {
         case Knob_Changed: return receiver.knobValueChanged(component, doubleValue);  // doubleValue is the new VoltageKnob value
        
      
         case Slider_Changed:   // doubleValue is the new slider value
         {
            controller.setSpreadAmount(doubleValue);
         }
         break;
      
         case Button_Changed:   // doubleValue is the new button/toggle button value
         {
         }
         break;
      
         case Switch_Changed:   // doubleValue is the new switch value
         {
            if (component == rangeSwitch) {
               inputBus.setIsSlow(doubleValue == 0.0);
            }
            if (component == waveformSwitch) {
               if (doubleValue == 0.0) {
                  controller.setSine();
               } else {
                  controller.setTriangle();
               }
            }
         }
         break;
      
         case Jack_Connected: return receiver.jackConnected(component);  // longValue is the new cable ID

      
         case Jack_Disconnected: return receiver.jackDisconnected(component);  // All cables have been disconnected from this jack

      
         case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
         {
         }
         break;
      
         case Object_MouseMove:   // called when mouse is over an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_MouseLeave:  // called when mouse leaves an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_LeftButtonDown:   // called when user left-clicks on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_LeftButtonUp:   // called when user releases left mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_RightButtonDown:   // called when user releases right mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_RightButtonUp:   // called when user right-clicks on an object that receives mouse notifications
         {
         }
         break;
      
         case Object_LeftButtonDoubleClick: // called when user left-button double-clicks on an object that receives mouse notifications
         {
         }
         break;
      
         // Less common notifications:
      
         case Named_Timer:   // object contains a String with the name of the timer that has fired
         {
         }
         break;
      
         case Canvas_Painting:   // About to paint canvas.  object is a java.awt.Rectangle with painting boundaries
         {
         }
         break;
      
         case Canvas_Painted:   // Canvas painting is complete
         {
         }
         break;
      
         case Control_DragStart:    // A user has started dragging on a control that has been marked as draggable
         {
         }
         break;
      
         case Control_DragOn:       // This control has been dragged over during a drag operation. object contains the dragged object
         {
         }
         break;
      
         case Control_DragOff:      // This control has been dragged over during a drag operation. object contains the dragged object
         {
         }
         break;
      
         case Control_DragEnd:      // A user has ended their drag on a control that has been marked as draggable
         {
         }
         break;
      
         case Label_Changed:        // The text of an editable text control has changed
         {
         }
         break;
      
         case SoundPlayback_Start:   // A sound has begun playback
         {
         }
         break;
      
         case SoundPlayback_End:     // A sound has ended playback
         {
         }
         break;
      
         case Scrollbar_Position:    // longValue is the new scrollbar position
         {
         }
         break;
      
         case PolyVoices_Changed:    // longValue is the new number of poly voices
         {
         }
         break;
      
         case File_Dropped:     // 'object' is a String containing the file path
         {
         }
         break;
      
         case Preset_Loading_Start:   // called when preset loading begins
         {
         }
         break;
      
         case Preset_Loading_Finish:  // called when preset loading finishes
         {
         }
         break;
      
         case Variation_Loading_Start:    // sent when a variation is about to load
         {
         }
         break;
      
         case Variation_Loading_Finish:   // sent when a variation has just finished loading
         {
         }
         break;
      
         case Tempo_Changed:     // doubleValue is the new tempo
         {
         }
         break;
      
         case Randomized:     // called when the module's controls get randomized
         {
         }
         break;
      
         case VariationListChanged:   // sent when a variation gets added, deleted, or renamed, or the variations list gets reordered
         {
         }
         break;
      
         case Key_Press:     // sent when module has keyboard focus and a key is pressed; object is a VoltageKeyPressInfo object
         {
         }
         break;
      
         case Reset:    // sent when the module has been reset to default settings
         {
         }
         break;
      
         case Keyboard_NoteOn:   // sent when a note has been pressed on a VoltageKeyboard object. longValue is the note value ( 0-127 )
         {
         }
         break;
      
         case Keyboard_NoteOff:   // sent when a note has been released on a VoltageKeyboard object. longValue is the note value ( 0-127 )
         {
         }
         break;
      
         case Curve_Changed:   // sent when user has edited a curve's value. 'object' will be a VoltageCurve.CurveChangeNotification object.
         {
         }
         break;
      }



      return false;
      //[/user-Notify]
   }


   //-------------------------------------------------------------------------------
   //  public void ProcessSample()

      //  ProcessSample is called once per sample. Usually it's where you read
      //  from input jacks, process audio, and write it to your output jacks.
      //  Since ProcesssSample gets called 48,000 times per second, offload CPU-intensive operations
      //  to other threads when possible and avoid calling native functions.
   //-------------------------------------------------------------------------------
   @Override
   public void ProcessSample()
   {
      //[user-ProcessSample]   Add your own process-sampling code here
      
      controller.processSamples();
      //[/user-ProcessSample]
   }


   //-------------------------------------------------------------------------------
   //  public String GetTooltipText( VoltageComponent component )

      //  Gets called when a tooltip is about to display for a control. Override it if
      //  you want to change what the tooltip displays - if you want a knob to work in logarithmic fashion,
      //  for instance, you can translate the knob's current value to a log-based string and display it here.
   //-------------------------------------------------------------------------------
   @Override
   public String GetTooltipText( VoltageComponent component )
   {
      //[user-GetTooltipText]   Add your own code here
      if (component == speedKnob) {
         var hz = speedKnob.GetValue();
         if (rangeSwitch.GetValue() == 0.0) {
            hz /= 8;
         }
         return decimalFormat.format(hz) + " Hz";
      }
   
      if (component == waveformSwitch) {
         if (waveformSwitch.GetValue() == 0.0) {
            return "Waveform: Sine";
         } else {
            return "Waveform: Triangle";
         }
      }
      return super.GetTooltipText( component );
      //[/user-GetTooltipText]
   }


   //-------------------------------------------------------------------------------
   //  public void EditComponentValue( VoltageComponent component, double newValue, String newText )

      //  Gets called after a user clicks on a tooltip and types in a new value for a control. Override this if
      //  you've changed the default tooltip display (translating a linear value to logarithmic, for instance)
      //  in GetTooltipText().
   //-------------------------------------------------------------------------------
   @Override
   public void EditComponentValue( VoltageComponent component, double newValue, String newText )
   {
      //[user-EditComponentValue]   Add your own code here



      //[/user-EditComponentValue]
      super.EditComponentValue( component, newValue, newText );
   }


   //-------------------------------------------------------------------------------
   //  public void OnUndoRedo( String undoType, double newValue, Object optionalObject )

      //  If you've created custom undo events via calls to CreateUndoEvent, you'll need to
      //  process them in this function when they get triggered by undo/redo actions.
   //-------------------------------------------------------------------------------
   @Override
   public void OnUndoRedo( String undoType, double newValue, Object optionalObject )
   {
      //[user-OnUndoRedo]   Add your own code here



      //[/user-OnUndoRedo]
   }


   //-------------------------------------------------------------------------------
   //  public byte[] GetStateInformation()

      //  Gets called when the module's state gets saved, typically when the user saves a preset with
      //  this module in it. Voltage Modular will automatically save the states of knobs, sliders, etc.,
      //  but if you have any custom state information you need to save, return it from this function.
   //-------------------------------------------------------------------------------
   @Override
   public byte[] GetStateInformation()
   {
      //[user-GetStateInformation]   Add your own code here



      return null;
      //[/user-GetStateInformation]
   }


   //-------------------------------------------------------------------------------
   //  public void SetStateInformation(byte[] stateInfo)

      //  Gets called when this module's state is getting restored, typically when a user opens a preset with
      //  this module in it. The stateInfo parameter will contain whatever custom data you stored in GetStateInformation().
   //-------------------------------------------------------------------------------
   @Override
   public void SetStateInformation(byte[] stateInfo)
   {
      //[user-SetStateInformation]   Add your own code here



      //[/user-SetStateInformation]
   }


   //-------------------------------------------------------------------------------
   //  public byte[] GetStateInformationForVariations()

      //  Gets called when a user saves a variation with this module in it.
      //  Voltage Modular will automatically save the states of knobs, sliders, etc.,
      //  but if you have any custom state information you need to save, return it from this function.
   //-------------------------------------------------------------------------------
   @Override
   public byte[] GetStateInformationForVariations()
   {
      //[user-GetStateInformationForVariations]   Add your own code here



      return GetStateInformation();
      //[/user-GetStateInformationForVariations]
   }


   //-------------------------------------------------------------------------------
   //  public void SetStateInformationForVariations(byte[] stateInfo)

      //  Gets called when a user loads a variation with this module in it.
      //  The stateInfo parameter will contain whatever custom data you stored in GetStateInformationForVariations().
   //-------------------------------------------------------------------------------
   @Override
   public void SetStateInformationForVariations(byte[] stateInfo)
   {
      //[user-SetStateInformationForVariations]   Add your own code here
      SetStateInformation(stateInfo);



      //[/user-SetStateInformationForVariations]
   }


   // Auto-generated variables
   private VoltageKnob mixCvAmount;
   private VoltageKnob feedbackCvAmount;
   private VoltageKnob speedCvAmount;
   private VoltageKnob depthCvAmount;
   private VoltageKnob timeCvAmount;
   private VoltageSlider spreadSlider;
   private VoltageAudioJack timeControl;
   private VoltageSwitch waveformSwitch;
   private VoltageSwitch rangeSwitch;
   private VoltageLabel textLabel9;
   private VoltageLabel textLabel22;
   private VoltageLabel textLabel21;
   private VoltageLabel textLabel8;
   private VoltageLabel textLabel7;
   private VoltageLabel textLabel5;
   private VoltageLabel textLabel6;
   private VoltageLabel textLabel4;
   private VoltageLabel textLabel3;
   private VoltageLabel textLabel20;
   private VoltageLabel textLabel19;
   private VoltageLabel textLabel18;
   private VoltageLabel textLabel17;
   private VoltageLabel textLabel16;
   private VoltageLabel textLabel15;
   private VoltageLabel textLabel14;
   private VoltageLabel textLabel13;
   private VoltageLabel textLabel12;
   private VoltageLabel textLabel11;
   private VoltageLabel textLabel10;
   private VoltageLabel textLabel2;
   private VoltageLabel textLabel1;
   private VoltageAudioJack feedbackControl;
   private VoltageKnob feedbackKnob;
   private VoltageAudioJack mixControl;
   private VoltageAudioJack speedControl;
   private VoltageAudioJack depthControl;
   private VoltageKnob mixKnob;
   private VoltageKnob speedKnob;
   private VoltageKnob depthKnob;
   private VoltageKnob timeKnob;
   private VoltagePolyJack outputJack;
   private VoltagePolyJack inputJack;


   //[user-code-and-variables]    Add your own variables and functions here

private Controller controller;
private InputBus inputBus;
private NotificationReceiver receiver = new NotificationReceiver();

private static final NumberFormat percentage = NumberFormat.getPercentInstance();
private static final DecimalFormat decimalFormat =  new DecimalFormat("#0.00"); 

private CvModulatableKnob makeModulatable(VoltageKnob knob, VoltageKnob modKnob, VoltageAudioJack jack) {
   return new CvModulatableKnob(
      knob.GetMinValue(),
      knob.GetMaxValue(),
      receiver.registerInput(jack, jack::GetValue),
      receiver.registerSmoothedKnob(knob, knob.GetValue()),
      receiver.registerSmoothedKnob(modKnob, modKnob.GetValue()));
}

   //[/user-code-and-variables]
}

 