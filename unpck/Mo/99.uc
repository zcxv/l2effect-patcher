class 99 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect5
		AttachOn=AM_LA
		EffectClass=Class'LineageEffect.mo_rapid_shot_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect6
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.mo_rapid_shot_ta'
	End Object
	Desc="레피드 샷" //Intrepid shots
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect5',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect6',SpecificStage=0)
}