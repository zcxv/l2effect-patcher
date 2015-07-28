class 3626 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect3
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.s_u805_ca_third'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect75
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.s_u805_channeling_beam'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect76
		AttachOn=AM_LA
		bUseCharacterRotation=True
		offset=(X=1.000000,Y=0.000000,Z=0.000000)
		EffectClass=Class'LineageEffect.s_u805_channeling_mesh'
	End Object
	Desc="포획" //Capture
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect3',SpecificStage=0)
	ChannelingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect75',SpecificStage=0)
	ChannelingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect76',SpecificStage=0)
}